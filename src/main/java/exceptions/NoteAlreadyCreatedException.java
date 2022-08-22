package exceptions;

import dtos.NoteResponse;

public class NoteAlreadyCreatedException extends RuntimeException{

    private NoteResponse note;

    public NoteAlreadyCreatedException(String message,NoteResponse note){
        super(message);
        this.note = note;
    }
    public NoteResponse getNote() { return note; }
}
