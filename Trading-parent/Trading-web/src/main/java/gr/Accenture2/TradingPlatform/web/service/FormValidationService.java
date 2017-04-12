package gr.Accenture2.TradingPlatform.web.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;
import gr.Accenture2.TradingPlatform.web.post.request.RegistrationForm;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.NullSafeComparator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Billy
 *
 * http://www.mkyong.com/regular-expressions/10-java-regular-expression-examples-you-should-know/
 *
 */
@Component
public class FormValidationService  implements Validator {
	
	/**
^                    # Start of the line
  [a-z0-9_-]	     # Match characters and symbols in the list, a-z, 0-9 , underscore , hyphen
             {3,15}  # Length at least 3 characters and maximum length of 15
$                    # End of the line
	 */
	private Pattern usernamePattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
	
	
	/**
(			#start of group #1
 0?[1-9]		#  01-09 or 1-9
 |                  	#  ..or
 [12][0-9]		#  10-19 or 20-29
 |			#  ..or
 3[01]			#  30, 31
) 			#end of group #1
  /			#  follow by a "/"
   (			#    start of group #2
    0?[1-9]		#	01-09 or 1-9
    |			#	..or
    1[012]		#	10,11,12
    )			#    end of group #2
     /			#	follow by a "/"
      (			#	  start of group #3
       (19|20)\\d\\d	#	    19[0-9][0-9] or 20[0-9][0-9]
       )		#	  end of group #3
	 */
	private Pattern datePattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	
	
	/**

^			#start of the line
  [_A-Za-z0-9-]+	#  must start with string in the bracket [ ], must contains one or more (+)
  (			#  start of group #1
    \\.[_A-Za-z0-9-]+	#     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
  )*			#  end of group #1, this group is optional (*)
    @			#     must contains a "@" symbol
     [A-Za-z0-9]+       #        follow by string in the bracket [ ], must contains one or more (+)
      (			#	   start of group #2 - first level TLD checking
       \\.[A-Za-z0-9]+  #	     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
      )*		#	   end of group #2, this group is optional (*)
      (			#	   start of group #3 - second level TLD checking
       \\.[A-Za-z]{2,}  #	     follow by a dot "." and string in the bracket [ ], with minimum length of 2
      )			#	   end of group #3
$			#end of the line

	 */
	private Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	/**

(			# Start of group
  (?=.*\d)		#   must contains one digit from 0-9
  (?=.*[a-z])		#   must contains one lowercase characters
  (?=.*[A-Z])		#   must contains one uppercase characters
  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
              .		#     match anything with previous condition checking
                {6,20}	#        length at least 6 characters and maximum of 20
)			# End of group
	 * 
	 */
	private Pattern passwordPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
	

	
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		if (obj instanceof  RegistrationForm){
			validate((RegistrationForm)obj, errors);
		}
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		if (RegistrationForm.class.equals(clazz)){
			
			return true;
		}
			
		return false;
	}
	
	private void validate(RegistrationForm form, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "firstname", "firstnameMandatory");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "lastnameMandatory");
		ValidationUtils.rejectIfEmpty(errors, "mobile", "mobileMandatory");

		if(form.getUsername() == null){
			ValidationUtils.rejectIfEmpty(errors, "username", "usernameMandatory");
		}else if(!usernamePattern.matcher(form.getUsername()).matches()){
			errors.reject("usernameInvalid");	
		}

		if(form.getBirthDate() == null){
			ValidationUtils.rejectIfEmpty(errors, "lastname", "birthDateMandatory");
		}else if(!datePattern.matcher(form.getBirthDate()).matches()){
			errors.reject("birthDateInvalid");	
		}

		if(form.getPassword() == null){
			ValidationUtils.rejectIfEmpty(errors, "password", "passwordMandatory");
		}else if(!passwordPattern.matcher(form.getPassword()).matches()){
			errors.reject("passwordInvalid");	
		}else{
			//ValidationUtils.rejectIfEmpty(errors, "passwordConfirm", "passwordConfirmMandatory");
		
			if(!StringUtils.equals(form.getPassword(), form.getPasswordConfirm())){
				errors.reject("passwordConfirmNotSame");	
			}
		
		}
		if(form.getEmail() == null ){
			
			ValidationUtils.rejectIfEmpty(errors, "email", "emailMandatory");
		
		}else if(!emailPattern.matcher(form.getEmail()).matches()){
			errors.reject("emailInvalid");	
		}
		

		
		
	}

}
