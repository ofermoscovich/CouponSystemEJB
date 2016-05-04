package entityDB;

import java.util.List;

//import javax.annotation.Resource;
//import javax.ejb.SessionContext;
import javax.ejb.Stateless;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

//import org.jboss.aop.util.logging.SystemOutLoggerPlugin;

/**
 * Session Bean implementation class IncomeSevice
 */
@Stateless(name="incomeSrv")
//@TransactionManagement(TransactionManagementType.CONTAINER) //Default
public class IncomeServiceBean implements IncomeServiceLocal {
	@PersistenceContext(unitName="couponSystem") 
	private EntityManager eManager;
	
//	@PersistenceUnit(unitName="couponSystem")
//	private EntityManagerFactory eManagerFactory;

//	@Resource
//	private SessionContext ctx; // only for BTN bean table??? management

    /**
     * Default constructor. 
     */
    public IncomeServiceBean() {

    }
	public void storeIncome(Income income) {
		try{
			eManager.persist(income);
		} catch (EntityExistsException e) {
			e.printStackTrace() ;
			System.out.println("Add Income! Entry already exists! No changes to Income Table made!" + "::::" + e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace() ;
			System.out.println("Add Income Failed! Table not Found!" + "::::" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace() ;
			System.out.println("Add Income Failed! General Error!" + "::::" + e.getMessage());
		}
	}

	public List<Income> viewAllIncome() {
		try {
			Query query = eManager.createQuery("SELECT OBJECT(inc) "
											 + "FROM Income AS inc ");

			@SuppressWarnings("unchecked")
			List<Income> list = (List<Income>)query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Income> viewAllIncomeById(long id, String name) {
		try {
			Query query = eManager.createQuery("SELECT OBJECT(inc) "
											 + "FROM Income AS inc "
											 + "WHERE inc.id = ?1 "
											 + "AND inc.name = ?2 ");
			query.setParameter(1,id);
			query.setParameter(2,name);
		
			@SuppressWarnings("unchecked")
			List<Income> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Income> viewAllIncomeByCustomer(long customerId, String name) {
		return viewAllIncomeById(customerId,name);
	}
	
	public List<Income> viewAllIncomeByCompany(long companyId, String name) {
		return viewAllIncomeById(companyId,name);
	}
}
