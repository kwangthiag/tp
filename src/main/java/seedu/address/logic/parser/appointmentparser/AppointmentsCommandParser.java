package seedu.address.logic.parser.appointmentparser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.appointmentcommands.AppointmentsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce an {@code AppointmentsCommand}.
 */
public class AppointmentsCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce an {@code AppointmentsCommand}.
     * <p>
     * This parser expects no arguments. If any argument is provided, a {@code ParseException} is thrown.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return An {@code AppointmentsCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public AppointmentsCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AppointmentsCommand.MESSAGE_USAGE));
        }
        return new AppointmentsCommand();
    }
}
