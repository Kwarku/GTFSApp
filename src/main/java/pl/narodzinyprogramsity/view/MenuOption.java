package pl.narodzinyprogramsity.view;

public enum MenuOption {
LOAD(1), SHOW_ALL(2), FIND_ROUT_BY_ID(3), EXIT(0), OTHER(-1);

private int number;

    MenuOption(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static MenuOption getOption(int chooseNumber) {
        for (MenuOption option : MenuOption.values()) {
            if (option.number == chooseNumber) {
                return option;
            }
        }
        return OTHER;
    }
}
