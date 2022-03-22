package com.cg.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.exception.AdminIdNotFoundException;
import com.cg.exception.BookingOrderIdNotFoundException;
import com.cg.exception.CanteenStaffIdNotFoundException;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.ErrorInfo;
import com.cg.exception.OrderIdNotFoundException;
import com.cg.exception.ProductsNotFoundException;
import com.cg.exception.UserIdNotFoundException;


@ControllerAdvice
/* @ControllerAdvice is an annotation provided by spring allowing you to write global code that can
be applied to a wide range of contollers-varying from all controllers to a chosen package or even a specific annotation.
*/
public class GlobalExceptionHandler {
	/* @ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom responses
	   to the client.
	 * @ResponseBody is a Spring annotation which binds a method return value to the web response body.
	 * HttpServeletRequest is an interface and extends the serveletRequest interface and give url path.
	 * LocalDateTime.now tells on which date and time the exception occurs.
	 */
			@ExceptionHandler(OrderIdNotFoundException.class)
			public @ResponseBody ErrorInfo checkOrderExistence(OrderIdNotFoundException e,HttpServletRequest req)
			{
				ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
				return ef;
				}
		
			 @ExceptionHandler(ProductsNotFoundException.class)
				public @ResponseBody ErrorInfo checkPizzaExistence(ProductsNotFoundException e,HttpServletRequest req)
				{
					ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
							return ef;
					}
				
				 @ExceptionHandler(AdminIdNotFoundException.class)
				 public @ResponseBody ErrorInfo checkMinCost(AdminIdNotFoundException e,HttpServletRequest req)
				 {
					 ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
						return ef;
				 }
				 @ExceptionHandler(UserIdNotFoundException.class)
					public @ResponseBody ErrorInfo checkCouponExistence(UserIdNotFoundException e,HttpServletRequest req)
					{
						ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
								return ef;
						}
					
					 @ExceptionHandler(BookingOrderIdNotFoundException.class)
					 public @ResponseBody ErrorInfo checkCouponOperation(BookingOrderIdNotFoundException e,HttpServletRequest req)
					 {
						 ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
							return ef;
					 }
					 @ExceptionHandler(CustomerIdNotFoundException.class)
						public @ResponseBody ErrorInfo checkCustomerExistence(CustomerIdNotFoundException e,HttpServletRequest req)
						{
							ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
									return ef;
						}
					 @ExceptionHandler(CanteenStaffIdNotFoundException.class)
						public @ResponseBody ErrorInfo checkAdminExistence(CanteenStaffIdNotFoundException e,HttpServletRequest req)
						{
							ErrorInfo ef=new ErrorInfo(e.getLocalizedMessage(), req.getRequestURI(),LocalDateTime.now());
							return ef;
							}
		}
