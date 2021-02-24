package messagegenerator;

import employees.Employee;

public class MessageGenerator {

    public String createMessageByType(MessageType messageType, Employee employee) {
        String message = null;
        switch (messageType) {
            case INFORM:
                message = createInformMessage(employee);
                break;
            case ALERT:
                message = createAlertMessage(employee);
                break;
        }
        return message;
    }

    public String createInformMessage(Employee employee) {
        String informMessage = String.format(MessageTemplate.INFORM_MESSAGE, employee.getFirstName(), employee.getLastName());
        return informMessage;
    }

    protected String createAlertMessage(Employee employee) {
        String alertMessage = String.format(MessageTemplate.ALERT_MESSAGE, employee.getFirstName(), employee.getLastName());
        return alertMessage;
    }
}
