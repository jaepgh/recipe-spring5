package jaep.springframework.recipeapp.converters;

import jaep.springframework.recipeapp.commands.NotesCommand;
import jaep.springframework.recipeapp.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {

        if (notes == null) {
            return null;
        }

        final NotesCommand command = new NotesCommand();
        command.setId(notes.getId());
        command.setRecipeNotes(notes.getRecipeNotes());

        return command;
    }
}
