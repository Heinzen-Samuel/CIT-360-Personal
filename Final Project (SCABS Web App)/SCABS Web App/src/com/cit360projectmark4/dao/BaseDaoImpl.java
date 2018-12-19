package com.cit360projectmark4.dao;

import com.cit360projectmark4.pojo.CapturedEntity;
import com.cit360projectmark4.pojo.ScabsEntity;
import com.cit360projectmark4.pojo.UsersEntity;
import com.cit360projectmark4.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl implements BaseDao {
    @Override
    public ScabsEntity getScab(int id) {
        Session session = HibernateUtil.getSession();
        ScabsEntity scab = (ScabsEntity) session.get(ScabsEntity.class, id);
        return scab;
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("BaseDaoImpl: login: starting");
        Session session = HibernateUtil.getSession();
        if (session != null) {
            try {
                System.out.println("BaseDaoImpl: login: checking login credentials");
                UsersEntity user = (UsersEntity) session.get(UsersEntity.class, username);
                System.out.println("BaseDaoImpl: login: credentials retrieved");
                if (password.equals(user.getPassword())) {
                    System.out.println("BaseDaoImpl: login: user " + user.toString() + " exists");
                    return true;
                }
            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: login: Exception occurred while reading user data: " + exception.getMessage());
                return false;
            }

        } else {
            System.out.println("BaseDaoImpl: login: DB server down.....");
        }
        return false;
    }

    @Override
    public String register(UsersEntity user) {
        System.out.println("BaseDaoImpl: register: starting");
        String msg = "Registration unsuccessful, try again...";
        Session session = HibernateUtil.getSession();
        if (session != null) {
            try {
                if (user != null) {
                    System.out.println("BaseDaoImpl: register: attempting to save user");
                    String username = (String) session.save(user);
                    System.out.println("BaseDaoImpl: register: username string retrieved");
                    session.beginTransaction().commit();
                    System.out.println("BaseDaoImpl: register: user " + username + " created");
                    msg = "User " + username + " created successfully, please login...";
                }
            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: register: Exception occurred while reading user data: " + exception.getMessage());
            }

        } else {
            System.out.println("BaseDaoImpl: register: DB server down.....");
            msg = "Registration couldn't complete because database is down. Contact Scab Admin";
        }
        System.out.println("BaseDaoImpl: register: msg = " + msg);
        return msg;
    }

    @Override
    public String recordCalories(String username, String string_calories) {
        System.out.println("BaseDaoImpl: recordCalories: starting");
        String msg = "Calories couldn't be recorded, try again...";
        Session session = HibernateUtil.getSession();

        if (session != null) {
            try {
                System.out.println("BaseDaoImpl: recordCalories: attempting input parse");
                int calories = Integer.parseInt(string_calories);
                System.out.println("BaseDaoImpl: recordCalories: retrieving user by username " + username);
                UsersEntity user = (UsersEntity) session.get(UsersEntity.class, username);

                int old_calories = user.getcalories();

                System.out.println("BaseDaoImpl: recordCalories: updating user object");
                user.setcalories(calories + old_calories);

                System.out.println("BaseDaoImpl: recordCalories: pushing to database");
                session.save(user);
                session.beginTransaction().commit();
                msg = calories + " have been added! Your total is now " + (calories + old_calories);
            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: recordCalories: Exception occurred while recording calories " + exception.getMessage());
            }

        } else {
            System.out.println("BaseDaoImpl: recordCalories: DB server down.....");
            msg = "Calories couldn't be recorded because database is down. Contact Scab Admin";
        }
        System.out.println("BaseDaoImpl: recordCalories: msg = " + msg);
        return msg;
    }

    @Override
    public String useCalories(String username, int calories) {
        System.out.println("BaseDaoImpl: useCalories: starting");
        String msg = "Calories couldn't be used, try again...";
        Session session = HibernateUtil.getSession();

        if (session != null) {
            try {
                System.out.println("BaseDaoImpl: useCalories: retrieving user by username " + username);
                UsersEntity user = (UsersEntity) session.get(UsersEntity.class, username);
                int cur_calories = user.getcalories();

                System.out.println("BaseDaoImpl: useCalories: subtracting calories");
                int new_calories = cur_calories - calories;

                if (new_calories >= 0) {
                    msg = "Calories accepted!";
                    System.out.println("BaseDaoImpl: useCalories: step amount accepted");
                    user.setcalories(new_calories);

                    System.out.println("BaseDaoImpl: useCalories: pushing to database");
                    session.save(user);
                    session.beginTransaction().commit();
                } else {
                    System.out.println("BaseDaoImpl: useCalories: step amount NOT accepted");
                    msg = "Calories can't be more then what you have, try again.....";
                }
            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: useCalories: Exception occurred while recording calories " + exception.getMessage());
            }
        } else {
            System.out.println("BaseDaoImpl: useCalories: DB server down...");
            msg = "Calories couldn't be used because database is down. Contact Scab Admin";
        }
        System.out.println("BaseDaoImpl: useCalories: msg = " + msg);
        return msg;
    }

    @Override
    public String storeCapturedScab(CapturedEntity new_scab) {
        System.out.println("BaseDaoImpl: storeCapturedScab: starting");
        String msg = "There was an error saving your Scab! Contact Scab Admin";
        Session session = HibernateUtil.getSession();

        if (session != null) {
            try {
                System.out.println("BaseDaoImpl: storeCapturedScab: attempting to save Scab");
                session.save(new_scab);
                System.out.println("BaseDaoImpl: storeCapturedScab: Scab is saved");
                session.beginTransaction().commit();
                System.out.println("BaseDaoImpl: storeCapturedScab: Scab is committed");
                msg = "Congrats! You chose " + new_scab.getScab() + "!";

            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: storeCapturedScab: Exception occurred saving captured " + exception.getMessage());
            }
        } else {
            System.out.println("BaseDaoImpl: storeCapturedScab: DB server down.....");
        }
        System.out.println("BaseDaoImpl: storeCapturedScab: msg = " + msg);
        return msg;
    }

    @Override
    public List<CapturedEntity> getCapturedScabs(String username) {
        System.out.println("BaseDaoImpl: getCapturedScabs: starting");
        Session session = HibernateUtil.getSession();

        List<CapturedEntity> results = null;
        if (session != null) {
            try {
                System.out.println("BaseDaoImpl: storeCapturedScab: attempting to retrieve Scabs");
                Criteria criteria = session.createCriteria(CapturedEntity.class);
                System.out.println("BaseDaoImpl: storeCapturedScab: adding username criteria");
                criteria.add(Restrictions.eq("owner", username));
                System.out.println("BaseDaoImpl: storeCapturedScab: setting criteria to list");
                results = criteria.list();

            } catch (Exception exception) {
                System.out.println("BaseDaoImpl: getCapturedScabs: Exception occurred retrieving captured Scabs"
                        + exception.getMessage());
                results = new ArrayList<>();
            }
        } else {
            System.out.println("BaseDaoImpl: getCapturedScabs: DB server down.....");
            results = new ArrayList<>();
        }

        return results;
    }
}
