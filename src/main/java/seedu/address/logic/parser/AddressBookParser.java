package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ModeCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.appointmentcommands.AppointmentsCommand;
import seedu.address.logic.commands.appointmentcommands.CancelCommand;
import seedu.address.logic.commands.appointmentcommands.FindAppointmentCommand;
import seedu.address.logic.commands.appointmentcommands.RescheduleCommand;
import seedu.address.logic.commands.appointmentcommands.ScheduleCommand;
import seedu.address.logic.commands.appointmentcommands.SortCommand;
import seedu.address.logic.commands.appointmentcommands.TodayCommand;
import seedu.address.logic.commands.appointmentcommands.UpcomingCommand;
import seedu.address.logic.commands.personcommands.AddCommand;
import seedu.address.logic.commands.personcommands.DeleteCommand;
import seedu.address.logic.commands.personcommands.DiagnoseCommand;
import seedu.address.logic.commands.personcommands.EditCommand;
import seedu.address.logic.commands.personcommands.FindCommand;
import seedu.address.logic.commands.personcommands.FindIllnessCommand;
import seedu.address.logic.commands.personcommands.PatientsCommand;
import seedu.address.logic.commands.personcommands.UndiagnoseCommand;
import seedu.address.logic.parser.appointmentparser.AppointmentsCommandParser;
import seedu.address.logic.parser.appointmentparser.CancelCommandParser;
import seedu.address.logic.parser.appointmentparser.FindAppointmentCommandParser;
import seedu.address.logic.parser.appointmentparser.RescheduleCommandParser;
import seedu.address.logic.parser.appointmentparser.ScheduleCommandParser;
import seedu.address.logic.parser.appointmentparser.SortCommandParser;
import seedu.address.logic.parser.appointmentparser.TodayCommandParser;
import seedu.address.logic.parser.appointmentparser.UpcomingCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.personparser.AddCommandParser;
import seedu.address.logic.parser.personparser.DeleteCommandParser;
import seedu.address.logic.parser.personparser.DiagnoseCommandParser;
import seedu.address.logic.parser.personparser.EditCommandParser;
import seedu.address.logic.parser.personparser.FindCommandParser;
import seedu.address.logic.parser.personparser.FindIllnessCommandParser;
import seedu.address.logic.parser.personparser.PatientsCommandParser;
import seedu.address.logic.parser.personparser.UndiagnoseCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case PatientsCommand.COMMAND_WORD:
            return new PatientsCommandParser().parse(arguments);

        case ScheduleCommand.COMMAND_WORD:
            return new ScheduleCommandParser().parse(arguments);

        case RescheduleCommand.COMMAND_WORD:
            return new RescheduleCommandParser().parse(arguments);

        case CancelCommand.COMMAND_WORD:
            return new CancelCommandParser().parse(arguments);

        case AppointmentsCommand.COMMAND_WORD:
            return new AppointmentsCommandParser().parse(arguments);

        case TodayCommand.COMMAND_WORD:
            return new TodayCommandParser().parse(arguments);

        case UpcomingCommand.COMMAND_WORD:
            return new UpcomingCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommandParser().parse(arguments);

        case HelpCommand.COMMAND_WORD:
            return new HelpCommandParser().parse(arguments);

        case UndoCommand.COMMAND_WORD:
            return new UndoCommandParser().parse(arguments);

        case RedoCommand.COMMAND_WORD:
            return new RedoCommandParser().parse(arguments);

        case FindAppointmentCommand.COMMAND_WORD:
            return new FindAppointmentCommandParser().parse(arguments);

        case SortCommand.COMMAND_WORD:
            return new SortCommandParser().parse(arguments);

        case DiagnoseCommand.COMMAND_WORD:
            return new DiagnoseCommandParser().parse(arguments);

        case UndiagnoseCommand.COMMAND_WORD:
            return new UndiagnoseCommandParser().parse(arguments);

        case FindIllnessCommand.COMMAND_WORD:
            return new FindIllnessCommandParser().parse(arguments);

        case ModeCommand.COMMAND_WORD:
            return new ModeCommand();

        case ListCommand.COMMAND_WORD:
            return new ListCommandParser().parse(arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
