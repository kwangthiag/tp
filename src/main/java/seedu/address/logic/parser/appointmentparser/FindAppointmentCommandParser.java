package seedu.address.logic.parser.appointmentparser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.appointmentcommands.FindAppointmentCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.appointmentfilters.FindPatientFilter;


/**
 * Parses user input and creates a {@code FindPatientAppointmentCommand} object for execution.
 * This class is responsible for taking a user's input string and converting it into
 * a corresponding command for finding patient appointments based on provided keywords.
 */
public class FindAppointmentCommandParser implements Parser<FindAppointmentCommand> {
    /**
     * Parses {@code userInput} and returns a FindPatientAppointmentCommand object to be executed.
     *
     * @param userInput user's input which is of type String.
     * @throws ParseException if {@code userInput} does not conform to the expected format.
     */
    @Override
    public FindAppointmentCommand parse(String userInput) throws ParseException {
        String trimmedArgs = userInput.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAppointmentCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindAppointmentCommand(new FindPatientFilter(Arrays.asList(nameKeywords)));
    }
}
