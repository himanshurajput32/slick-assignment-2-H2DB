package repoSpec

import com.example.models.Project
import com.example.repos.ProjectRepo
import org.scalatest.AsyncFunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by knoldus on 15/3/17.
  */
class ProjectRepoTest extends AsyncFunSuite{
test("Insert Project"){
ProjectRepo.insert(Project(1,"Project 1")).map(x=>assert(x==1))
}
  test("Delete Project"){
    ProjectRepo.delete(1).map(x=>assert(x==2))
  }
  test("Delete non existing Data"){
    ProjectRepo.delete(2).map(x=>assert(x==0))
  }

  test("Update Project"){
    ProjectRepo.update(1,"ppppp").map(x=>assert(x==2))
  }
  test("Upsert Project"){
    ProjectRepo.upsert(Project(3,"himanshu")).map(x=>assert(x==1))
  }
test("Right JOIN"){
  assert(Await.result(ProjectRepo.rightJoinExample,Duration.Inf).length==3)
}
  test("Left JOIN"){
    assert(Await.result(ProjectRepo.leftJoinExample,Duration.Inf).length==8)
  }
}
