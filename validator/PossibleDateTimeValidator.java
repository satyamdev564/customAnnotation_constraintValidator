package validator;

import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

    public class PossibleDateTimeValidator implements ConstraintValidator<PossibleDateTime, String> {
        String pattern;

        String[] fallbackPatterns;

        @Override
        public void initialize( PossibleDateTime constraintAnnotation ) {
            this.pattern = constraintAnnotation.pattern();
            this.fallbackPatterns = constraintAnnotation.fallbackPatterns();
        }

        @Override
        public boolean isValid( String value, ConstraintValidatorContext constraintValidatorContext ) {
            if ( value == null ) {
                return true;
            } else if ( value != null && validateDate( value ) ) {
                return true;
            }
            return false;
        }

        public boolean validateDate( String strDate ) {
            boolean isValid = false;
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern( pattern );
            try {
                LocalDate.parse( strDate, formatterDate );
                isValid = true;
            } catch ( DateTimeParseException e ) {
                if ( !ObjectUtils.isEmpty( this.fallbackPatterns ) ) {
                    String[] var4 = this.fallbackPatterns;
                    int var5 = var4.length;
                    int var6 = 0;

                    while ( var6 < var5 ) {
                        String fallBackPattern = var4[var6];

                        try {
                            DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern( fallBackPattern );
                            LocalDateTime.parse( strDate, formatterDateTime );
                            return true;
                        } catch ( DateTimeParseException dtpe ) {
                            ++var6;
                        }
                    }
                }
            }
            return isValid;
        }
    }