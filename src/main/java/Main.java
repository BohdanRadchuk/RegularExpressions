import controller.Controller;
import model.NoteBook;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        NoteBook noteBook = new NoteBook();
        Controller controller = new Controller(view, noteBook);
        controller.createNewNote();
    }
}
