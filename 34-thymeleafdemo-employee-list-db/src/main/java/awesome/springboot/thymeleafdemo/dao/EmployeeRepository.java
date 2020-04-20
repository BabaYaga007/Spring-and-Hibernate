package awesome.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import awesome.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
