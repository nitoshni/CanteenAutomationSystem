package com.cg.exception;
/*
 * This is a user defined exception for ProductsId not found.
 */
public class ProductsNotFoundException extends Exception
    {	
	public ProductsNotFoundException(String ProductNotFound)
	{
		super(ProductNotFound);
	}
}

