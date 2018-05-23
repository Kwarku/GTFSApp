package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;
import pl.narodzinyprogramsity.models.Transfer;
import pl.narodzinyprogramsity.utils.CreateTransfer;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Transfer tr1;
    private Transfer tr2;
    private Transfer tr3;
    private Transfer testTransfer;

    private TransferRepository emptyRepository;
    private TransferRepository testRepository;

    private int startSize;
    private int endSize;

    private List<Transfer> resultList;

    @Before
    public void setUp() {
        tr1 = CreateTransfer.createTestTransfer1();
        tr2 = CreateTransfer.createTestTransfer2();
        tr3 = CreateTransfer.createTestTransfer3();
        testTransfer = CreateTransfer.createOriginalTransfer();

        emptyRepository = new TransferRepository();
        testRepository = new TransferRepository();
        testRepository.list.add(tr1);
        testRepository.list.add(tr2);
        testRepository.list.add(tr3);

        startSize = Integer.MIN_VALUE;
        endSize = Integer.MIN_VALUE;

        resultList = new ArrayList<>();
    }

    @Test
    public void addTest() {
        startSize = emptyRepository.list.size();

        String id1 = emptyRepository.add(tr1);
        String id2 = emptyRepository.add(tr2);
        endSize = emptyRepository.list.size();

        assertThat(startSize).isEqualTo(0).isLessThan(endSize);
        assertThat(endSize).isEqualTo(2);
        assertThat(id1).isEqualTo(tr1.getId());
        assertThat(id2).isEqualTo(tr2.getId());
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        Transfer transfer = testRepository.get(tr3.getId());

        assertThat(transfer).isEqualTo(tr3);
    }

    @Test
    public void getNoExistObjTest() {
        Transfer noExist = testRepository.get("noExistObjId");

        assertThat(noExist).isEqualTo(Transfer.NOT_FOUND);
    }

    @Test
    public void getByNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
    }

    @Test
    public void getAllTest() {
        resultList = testRepository.getAll();

        assertThat(resultList.size()).isEqualTo(3);
        assertThat(resultList.get(1)).isInstanceOf(Transfer.class);
    }

    @Test
    public void getAllFromEmptyRepositoryTest() {
        resultList = emptyRepository.getAll();

        assertThat(resultList).isNotNull().isEmpty();
        assertThat(resultList.size()).isEqualTo(0);
    }

    @Test
    public void updateTest() {
        testRepository.update(tr2, testTransfer);

        Transfer transfer = testRepository.get(testTransfer.getId());
        resultList = testRepository.getAll();

        assertThat(transfer).isEqualTo(testTransfer);
        assertThat(resultList.size()).isEqualTo(3);
        assertThat(resultList.get(0)).isEqualTo(tr1);
        assertThat(resultList.get(1)).isNotEqualTo(tr2);
        assertThat(resultList.get(2)).isEqualTo(tr3);
    }

    @Test
    public void updateByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(tr2, null);
    }

    @Test
    public void updateEmptyRepositoryTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.update(tr1, null);
    }

    @Test
    public void updateNoExistObjTest() {
        Transfer noExistTransfer = CreateTransfer.createTestTransfer4();

        testRepository.update(noExistTransfer, testTransfer);
        resultList = testRepository.getAll();

        assertThat(resultList.size()).isEqualTo(3);
        assertThat(resultList.get(0)).isEqualTo(tr1);
        assertThat(resultList.get(1)).isEqualTo(tr2);
        assertThat(resultList.get(2)).isEqualTo(tr3);
    }

    @Test
    public void deleteByObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete(tr1);
        testRepository.delete(tr2);
        endSize = testRepository.list.size();

        assertThat(startSize).isEqualTo(3).isGreaterThan(endSize);
        assertThat(endSize).isEqualTo(1);
    }

    @Test
    public void deleteByStringTest() {
        startSize = testRepository.list.size();

        testRepository.delete(tr2.getId());
        testRepository.delete(tr3.getId());
        endSize = testRepository.list.size();

        assertThat(startSize).isEqualTo(3).isGreaterThan(endSize);
        assertThat(endSize).isEqualTo(1);

    }

    @Test
    public void deleteByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((Transfer) null);
        testRepository.delete((String) null);
    }

    @Test
    public void deleteNoExistObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete("noExistObj");
        testRepository.delete(testTransfer);
        endSize = testRepository.list.size();


        assertThat(startSize).isEqualTo(endSize);
    }

    @Test
    public void deleteFromEmptyRepositoryTest() {
        startSize = emptyRepository.list.size();

        emptyRepository.delete(tr1);
        endSize = emptyRepository.list.size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(0);
    }
}