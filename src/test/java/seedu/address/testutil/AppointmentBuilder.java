package seedu.address.testutil;

import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.VALID_DESCRIPTION_ONE;

import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentDescription;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.person.Person;
import seedu.address.model.tag.PriorityTag;

/**
 * Apartment builder helps to build test appointment objects.
 */
public class AppointmentBuilder {


    private static final AppointmentTime DEFAULT_TIME = new AppointmentTimeBuilder().build();
    private static final Person DEFAULT_PATIENT = new PersonBuilder().build();
    private static final String DEFAULT_PATIENT_STRING = DEFAULT_PATIENT.getName().fullName;
    private static final String DEFAULT_DESCRIPTION = VALID_DESCRIPTION_ONE;


    // Identity fields
    private AppointmentTime appointmentTime;
    private Person patient;

    private PriorityTag priorityTag;

    private AppointmentDescription appointmentDescription;
    /**
     * Creates a {@code AppointmentBuilder} with default settings.
     */
    public AppointmentBuilder() {
        appointmentTime = DEFAULT_TIME;
        patient = DEFAULT_PATIENT;
        appointmentDescription = new AppointmentDescription(DEFAULT_DESCRIPTION);
    }

    /**
     * Creates a {@code AppointmentBuilder} with data provided by {@code appointment}.
     */
    public AppointmentBuilder(Appointment appointment) {
        appointmentTime = appointment.getAppointmentTime();
        patient = appointment.getPerson();
        appointmentDescription = appointment.getAppointmentDescription();
        priorityTag = appointment.getPriorityTag();
    }

    public Appointment build() {
        return new Appointment(this.patient, this.appointmentTime, this.appointmentDescription, this.priorityTag);
    }

    /**
     * Sets the {@code AppointmentTime} for the Appointment being built.
     */
    public AppointmentBuilder withAppointmentTime(String start, String end) {
        this.appointmentTime = new AppointmentTimeBuilder().withStart(start).withEnd(end).build();
        return this;
    }

    /**
     * Sets the {@code Patient} for the Appointment being built.
     */
    public AppointmentBuilder withPatient(Person patient) {
        this.patient = patient;
        return this;
    }

    /**
     * Sets the {@code Description} for the Appointment being built.
     */
    public AppointmentBuilder withDescription(String description) {
        this.appointmentDescription = new AppointmentDescription(description);
        return this;
    }

    /**
     * Sets the {@code PriorityTag} for the Appointment being built.
     */
    public AppointmentBuilder withPriorityTag(String priorityTag) {
        this.priorityTag = new PriorityTag(priorityTag);
        return this;
    }
}
