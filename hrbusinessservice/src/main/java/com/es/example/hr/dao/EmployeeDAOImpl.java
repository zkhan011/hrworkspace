package com.es.example.hr.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;











import org.springframework.stereotype.Repository;

import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	


	public void insertEmployee(Employee emp) {
		entityManager.persist(emp);
	}

	public List<Employee> findAllEmployees() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}	
	
	public List<Job> findAllJobs(){		
		return entityManager.createQuery("select j from Job j").getResultList();
	}
	
	public List<Department> findAllDepartments(){
		return entityManager.createQuery("select d from Department d").getResultList();
	}	
	
	public List<Region> findAllRegions() {
		return entityManager.createQuery("select r from Region r").getResultList();
	}
	
	public List<Country> findAllCountries() {
		return entityManager.createQuery("select c from Country c").getResultList();
	}	
	
	public List<Location> findAllLocations() {
		return entityManager.createQuery("select l from Location l").getResultList();
	}	
	
	public List<JobHistory> findAllJobHistory() {
		return entityManager.createQuery("select h from JobHistory h").getResultList();
	}

	public void findOneEmployee1(int id) {
		
		entityManager.createQuery("select e from Employee e where e.id='"+id+"'").getFirstResult();
	}

	public List<Employee> findOneEmployee(int id) {
		return entityManager.createQuery("select e from Employee e where e.id='"+id+"'").getResultList();
		
	}

	public void updateEmployee(Employee employee) {
		Query query = entityManager.createQuery("update Employee e set "+"e.firstName = :firstName,"+" e.lastName = :lastName,"+"e.email= :email"+ 
				" where e.id = :id");
        query.setParameter("firstName",employee.getFirstName());
        query.setParameter("lastName",employee.getLastName());
        query.setParameter("email",employee.getEmail());
        query.setParameter("id", employee.getId());
        query.executeUpdate();		
		
		
	}

	public void deleteEmployee(Employee employee) {
		Query query = entityManager.createQuery("delete Employee e "+ "where e.id=:id");
		query.setParameter("id", employee.getId());
		query.executeUpdate();
		
	}
	
	public List<Employee> searchEmployee1(String countryName, String firstName, String lastName,int setFirstResult,int setLastResult){
	
		//String query = "select e from Employee e ";
		String query = "select e from Employee e ";
		
		if(countryName!= null)
		{
			//query= query+ " from Employee e , Department d , Location l  innerjoin e on e.department.location.id= l.id ";
			//query= query+ " from Employee e join e.department.location ";
			query= query+ "join e.department.location.country where (e.department.location.country.countryName = :countryName)";
			//query= query+ "join e.department.location.country ";
			
		}
		
		if(firstName != null)
		{
		   // query = query + "where e.firstName=:firstName ";
		  // query = query + "where e.firstName like :firstName";
		    query = query + " AND (e.firstName like :firstName)";
	}
		
//		
//		
		Query qu = entityManager.createQuery(query);
//		
		if (firstName != null)
		{		
		qu.setParameter("firstName","%"+firstName+"%");
		}
		 qu.setParameter("countryName",countryName);
		 qu.setFirstResult(setFirstResult);
		 qu.setMaxResults(setLastResult);
		
		 return qu.getResultList();
		
		
	}

	public List<Employee> searchEmployee() {
//		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//		try {
//			fullTextEntityManager.createIndexer().startAndWait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// create native Lucene query unsing the query DSL
//		// alternatively you can write the Lucene query using the Lucene query parser
//		// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
//		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
//		    .buildQueryBuilder().forEntity(Employee.class).get();
//		org.apache.lucene.search.Query luceneQuery = qb
//		  .keyword()
//		  .onFields("firstName", "lastName")
//		  .matching("Java rocks!")
//		  .createQuery();
//
//		// wrap Lucene query in a javax.persistence.Query
//		javax.persistence.Query jpaQuery =
//		    fullTextEntityManager.createFullTextQuery(luceneQuery, Employee.class);
//
//		// execute search
//		List result = jpaQuery.getResultList();
//		return result;
		return null;
	}

	public List<Job> findOneJ(String id) {
		
		return entityManager.createQuery("select j from Job j where j.id='"+id+"'").getResultList();
	}

	public List<Department> findOneD(String id) {
		
	 return entityManager.createQuery("select d from Department d where d.id='"+id+"'").getResultList();
	}

	
 

	
	
}
