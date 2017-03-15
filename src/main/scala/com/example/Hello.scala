package com.example

import com.example.repos.ProjectRepo

import scala.concurrent.Await
import scala.concurrent.duration.Duration


object Hello extends App{
  println(Await.result(ProjectRepo.leftJoinExample,Duration.Inf).length)
}