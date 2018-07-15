package controller;

import controller.util.CheckRegex;
import model.entity.Note;

public class FieldsFilling {
    private Note note;

    public FieldsFilling(Note note) {
        this.note = note;
    }


    public void nameSet(String regex, String input) {
       /* boolean checkResult =
        if (checkResult) {*/
            note.setName(input);
            System.out.println(note);
      /*  }
        return checkResult;*/
    }
}
