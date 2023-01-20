package com.revature.poms.app;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.poms.constant.Constant;
import com.revature.poms.service.RegisterPageImpl;

public class Application {

	private static final Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		RegisterPageImpl rp = new RegisterPageImpl();
		boolean check = false;
		while (!check) {
			check = rp.registrationAndLogin();
		}
		System.out.println(Constant.WELCOME_MESSAGE);
		Scanner sc = new Scanner(System.in);
		Menu.itemMenu(sc);
		sc.close();
		log.info(Constant.END_MESSAGE);

	}

}