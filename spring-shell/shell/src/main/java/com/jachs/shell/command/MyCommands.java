package com.jachs.shell.command;

import javax.validation.constraints.Size;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/***
 * 
 * @author zhanchaohan
 * @see https://docs.spring.io/spring-shell/docs/2.0.0.RELEASE/reference/htmlsingle/#_using_spring_shell
 */
@ShellComponent
public class MyCommands {
	/***
	 * 输入:add param param</br>
	 * 输入:help</br>
	 * 输入:exit</br>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@ShellMethod("Add two integers together.")
	public int add(int a, int b) {
		return a + b;
	}

	/***
	 * echo 1 2 3</br>
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	@ShellMethod("Display stuff.")
	public String echo(int a, int b, int c) {
		return String.format("You said a=%d, b=%d, c=%d", a, b, c);
	}

	/***
	 * greet:输出Hello World</br>
	 * greet awesome:输出Hello awesome
	 * 
	 * @param who
	 * @return
	 */
	@ShellMethod("Say hello.")
	public String greet(@ShellOption(defaultValue = "World") String who) {
		return "Hello " + who;
	}

	/***
	 * addarity 1 2 3.3
	 * 
	 * @param numbers
	 * @return
	 */
	@ShellMethod("addArity Numbers.")
	public float addarity(@ShellOption(arity = 3) float[] numbers) {
		return numbers[0] + numbers[1] + numbers[2];
	}

	/***
	 * shutdown,输出You said false</br>
	 * shutdown --force,输出You said true
	 * 
	 * @param force
	 * @return
	 */
	@ShellMethod("Terminate the system.")
	public String shutdown(boolean force) {
		return "You said " + force;
	}
	/***
	 * change-password hello,长度不够8-40</br>
	 * change-password helloWordl
	 * @param password
	 * @return
	 */
	@ShellMethod("Change password.")
	public String changePassword(@Size(min = 8, max = 40) String password) {
		return "Password successfully set to " + password;
	}

}