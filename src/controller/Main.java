package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SkillDAO;
import model.Skill;

public class Main {

	public static void main(String[] args)
			throws NumberFormatException, IOException, SQLException, ClassNotFoundException {

		SkillDAO skilldao = new SkillDAO();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c;
		do {
			System.out.println("1. Update Skills");
			System.out.println("2. List All Skills");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			int ch = Integer.parseInt(br.readLine());
			c = ch;
			switch (ch) {
			case 1:

				System.out.println("Enter Skill ID");
				long id = Long.parseLong(br.readLine());
				System.out.println("Enter Skill Name");
				String name = br.readLine();

				Skill skill = new Skill(id, name);

				// System.out.println(skill.getSkillName());
				// System.out.println(skill.getSkillId());

				skilldao.setSkill(skill);
				break;

			case 2:
				ArrayList<String> l = (ArrayList<String>) skilldao.listAllSkills();
				int i = 1;
				for (String s : l) {

					System.out.println(i + " " + s);
					i++;

				}
				System.out.println();

				break;
			default:
				break;
			}
		} while (c != 3);
	}
}
