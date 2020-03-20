package member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberRegistValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		//파라미터 타입이 Object가 아니라면 모든 데이터 타입을 validate할 수 없다. 자손의 주소를 부모에게 넣는다(?)
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");

		if (regReq.hashPassword()) {
			if (regReq.getPassword().length() < 5) {
				errors.rejectValue("password", "shortPassword");
			} else if (!regReq.isSamePasswordConfirmPassword()) {
				errors.rejectValue("confirmPassword", "notSame");
			}
		}
		Address address = regReq.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		} else {
			errors.pushNestedPath("address");
			try {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2", "required");
			} finally {
				errors.popNestedPath();
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "required");

	}

}
