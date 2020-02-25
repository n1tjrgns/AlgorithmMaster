package testdome;

import org.junit.Assert;
import org.junit.Test;
/*Using JUnit 4's Assert class, write tests for the Account class that cover the following cases:

The deposit and withdraw methods will not accept negative numbers.
Account cannot overstep its overdraft limit.
The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
The withdraw and deposit methods return the correct results.
예금과 인출 방법은 마이너스 숫자를 받아들이지 않을 것이다.
회계는 당좌대월 한도를 초과할 수 없다.
예금과 인출 방법은 각각 정확한 금액을 입금하거나 인출한다.
인출 및 입금 방법은 정확한 결과를 반환한다.

*/
public class AccountTest {

    //- assertEquals([message,] double expected, double actual, double delta) :
    // 오차 범위내의 값은 동일한 값으로 판단합니다.

        private double epsilon = 1e-6;

        @Test
        public void accountCannotHaveNegativeOverdraftLimit() {
            Account account = new Account(-20);

            Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
        }

        @Test
        public void depositIsNotAllowMinus(){
            Account account = new Account(20);
            boolean result = account.deposit(-20);

            Assert.assertFalse(result);
        }

        @Test
        public void withdrawIsNotAllowMinus(){
            Account account = new Account(20);
            boolean result = account.withdraw(-20);

            Assert.assertFalse(result);
        }

        @Test
        public void getBalanceFuncCheck(){
            Account account = new Account(20);
            boolean result  = account.deposit(20);

            Assert.assertTrue(result);
            Assert.assertEquals(20,account.getBalance(), epsilon);

        }

        @Test
        public void withdrawFuncCheck(){
            Account account = new Account(20);
            boolean result = account.withdraw(20);

            Assert.assertEquals(-20,account.getBalance(), epsilon);
            Assert.assertTrue(result);
        }

        @Test
        public void getOverdraftLimitCheck(){
            Account account = new Account(10);
            boolean result = account.withdraw(20);
            //밸런스 값을 ㅈ가져와서 overdraft보다 크면 false이게
            Assert.assertFalse(result);
            Assert.assertEquals(0, account.getBalance(), epsilon);
        }
    }