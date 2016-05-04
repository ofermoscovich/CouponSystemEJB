package entityDB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Message-Driven Bean implementation class for: IncomeCustomerBean
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationType", 
										  propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName = "destination", 
										  propertyValue = "queue/couponSystem-Queue")
		})
public class IncomeConsumerBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public IncomeConsumerBean() {
        // TODO Auto-generated constructor stub
    }
	@EJB
	private IncomeServiceLocal stub;
	/**
     * onMessage
     */
    public void onMessage(Message msg) {
    	ObjectMessage om = (ObjectMessage) msg;
    	try {
			Income income = (Income)om.getObject();
	        //Income income = (Income) (((ObjectMessage)msg).getObject());
			stub.storeIncome(income);
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }
}
