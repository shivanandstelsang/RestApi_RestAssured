package api.endpoints;

/*
 * url -> https://api.dev.tasklyhub.com/api/v1/
 * create domain -> https://api.dev.tasklyhub.com/api/v1/domains
 * get domain -> https://api.dev.tasklyhub.com/api/v1/domains/20
 * update domain -> https://api.dev.tasklyhub.com/api/v1/domains/15
 * delete domain -> https://api.dev.tasklyhub.com/api/v1/domains/20
 * get all domains -> https://api.dev.tasklyhub.com/api/v1/domains
 */

public class Routes {
public static String base_url = "https://api.dev.tasklyhub.com/api/v1/"; 

public static String post_url = base_url+"domains";
public static String get_url = base_url+"domains/{id}";
public static String update_url = base_url+"domains/{id}";
public static String delete_url = base_url+"domains/{id}";
public static String getall_url = base_url+"domains";

}
