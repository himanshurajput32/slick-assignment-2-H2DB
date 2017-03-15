  import javax.inject.Inject

  import com.example.models.Employee
  import com.example.tables.EmployeeRepo
  import org.scalatest._

  import scala.concurrent.ExecutionContext.Implicits.global

  class EmployeeRepoTest extends AsyncFunSuite{

    test("Delete Existing data") {

      EmployeeRepo.delete(1).map(x => assert(x == 1))
    }
    test("Delete non Existing data") {

      EmployeeRepo.delete(4).map(x => assert(
        x == 0))
    }
    test("Insert data") {
      EmployeeRepo.insert(Employee(4, "dddd")).map(x => assert(x == 1))
    }
    test("Find data ") {
      EmployeeRepo.getAllEmployee.map(x => assert(x.length == 2))
    }
    test("Update Data") {
      EmployeeRepo.update(1, "Kunal").map(x => assert(x == 1))
    }
  }
