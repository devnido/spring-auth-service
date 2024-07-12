package com.example.auth.base;

public abstract class BaseUseCase<Params, Result> {

  public abstract Result execute(Params params) throws Exception;

}