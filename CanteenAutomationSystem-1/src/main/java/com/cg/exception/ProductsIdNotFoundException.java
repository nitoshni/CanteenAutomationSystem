package com.cg.exception;
/*
 * This is a user defined exception for ProductsId not found.
 */
public class ProductsIdNotFoundException extends Exception{
	public ProductsIdNotFoundException(String ProductsIdNotFound)
	{
		super(ProductsIdNotFound);
	}

}
