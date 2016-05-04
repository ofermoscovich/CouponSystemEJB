package entityDB;

import java.util.List;
import javax.ejb.Local;

@Local
public interface IncomeServiceLocal {

	public void storeIncome(Income income) ;
	public List<Income> viewAllIncome();
	public List<Income> viewAllIncomeByCustomer(long customerId, String name);
	public List<Income> viewAllIncomeByCompany(long companyId, String name);

}
