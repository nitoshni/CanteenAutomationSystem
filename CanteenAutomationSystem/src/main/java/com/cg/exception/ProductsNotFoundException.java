package com.cg.exception;

public class ProductsNotFoundException extends Exception
    {	
	public ProductsNotFoundException(String ProductNotFound)
	{
		super(ProductNotFound);
	}
}

