package edu.poly.spring.controller;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rank")
public class RankController {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@GetMapping("/rank")
	@Transactional
	public String rank(ModelMap model) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "select s.hoten, d.name, s.id from Records r " + 
				"join r.staff s on s.id = r.staff.id " + 
				"join s.depart d on s.depart.id = d.id " + 
				"group by s.hoten, d.name ,s.id " + 
				"order by (SUM(CASE WHEN r.type=1 THEN 1 ELSE 0 END) - SUM(CASE WHEN r.type=0 THEN 1 ELSE 0 END)) desc";
		Query query = session.createQuery(hql).setMaxResults(9);
		List<Object[]> list = query.list();
		
		model.addAttribute("awards",list);
		return "Staffs/rank";
	}
}
