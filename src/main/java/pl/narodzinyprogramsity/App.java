package pl.narodzinyprogramsity;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.module.ParserModule;
import pl.narodzinyprogramsity.module.ReaderModule;
import pl.narodzinyprogramsity.module.RepositoryModule;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.readers.FeedReader;
import pl.narodzinyprogramsity.repository.FeedRepository;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        FeedParser<Agency> agencyParser = ParserModule.getAgencyParser();
        FeedRepository<Agency> agencyRepository = RepositoryModule.getAgencyRepository();
        FeedReader<Agency> agencyReader = ReaderModule.getAgencyReader(agencyRepository, agencyParser);


        FeedReader<Rout> routFeedReader = ReaderModule.getRoutReader();

        try {
            agencyReader.read();
            routFeedReader.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
        agencyRepository.getAll().forEach(System.out::println);
        RepositoryModule.getRoutRepository().getAll().forEach(System.out::println);

    }
}
