package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /*
       return 값은 static의 정적 페이지를 뷰를 리턴하거나
       templates 뷰를 리턴 시킨다.
     */
    @GetMapping("hello") // 주소 http://localhost:8080/hello
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // hello.html에서 사용할 키와 데이터
        return "hello";  // resources:templates/ +{ViewName}+ .html 리턴 값의 templates 폴더에있는 html 이름을 찾아서 랜더링 된다.
    }

    @GetMapping("user") // 주소 http://localhost:8080/user
    public String user(Model model){
        model.addAttribute("name","Jaewon");
        model.addAttribute("age","3");
        model.addAttribute("address","서울");
        return "home";
    }

    @GetMapping("hellomvc") // 주소 http://localhost:8080/hellomvc?name=ddd
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-mvc";
    }


    /*
      ResponseBody 데이터를 직접 리턴 한다. Api 방식을 사용할때 쓴다.
     */

    @GetMapping("apitest") // http://localhost:8080/apitest
    @ResponseBody //ResponseBody가 있으면 뷰로 넘기지 않고 바로 데이터를 리턴 시킨다
    public String test(){
        return "test";
    }

    @GetMapping("addUser") // http://localhost:8080/addUser?name=jaewon&age=19
    @ResponseBody //ResponseBody가 객체를 반환 시키면 json으로 변경하여 반환 된다.
    public User userInfo(@RequestParam("name") String name, @RequestParam("age") int age){
        User use = new User();
        use.setAge(age);
        use.setName(name);
        return use;
    }

    static class User{
        private String name;
        private int age;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
