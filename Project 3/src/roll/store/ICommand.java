package roll.store;

public interface ICommand {
    public void make();

    void make(Roll roll, String sauce);
    Roll getResult();
}
