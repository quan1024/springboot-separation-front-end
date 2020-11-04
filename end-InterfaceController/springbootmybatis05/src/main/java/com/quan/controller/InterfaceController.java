package com.quan.controller;
import com.quan.entity.Hero;
import com.quan.entity.Player;
import com.quan.entity.ResResult;
import com.quan.service.HeroService;
import com.quan.service.LoginInfoService;
import com.quan.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;

@Controller
@RequestMapping("/api")
public class InterfaceController {

    public static HashMap<String,String> sessionMap=new HashMap<String,String>();
    @Autowired
    private LoginInfoService loginInfoService;
    @Autowired
    private HeroService heroService;
    @Autowired
    private PlayerService playerService;
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/getAllHero")
    @ResponseBody
    public  Collection apiGetAllHero(){
        Collection<Hero> heroCollection= heroService.selectAllHero();
        return heroCollection;
    }
    @RequestMapping("/selectHeroByName")
    @ResponseBody
    public Hero apiGetHeroByName(@RequestParam("name") String name){
        Hero selhero=new Hero();
        selhero.setName(name);
        System.out.println(name);
        if(heroService.selectHeroByName(selhero)==null){
            System.out.println("查无此英雄");
            Hero notfoundhero=new Hero();
            notfoundhero.setName("notfoundhero");
            return notfoundhero;
        }
        else{
            Hero hero = heroService.selectHeroByName(selhero);
            return hero;
        }
    }
    @RequestMapping("/addHero")
    @ResponseBody
    public int apiAddHero(@RequestParam("name") String name, @RequestParam("hp") int hp, @RequestParam("armor") int armor, @RequestParam("moveSpeed") int moveSpeed) {
        Hero heroadd = new Hero(name, hp, armor, moveSpeed);
        try {
            heroService.addHero(heroadd);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    @RequestMapping("/updateHeroByName")
    @ResponseBody
    public int updateHeroByName(@RequestParam("name") String name, @RequestParam("hp") int hp, @RequestParam("armor") int armor, @RequestParam("moveSpeed") int moveSpeed){
        Hero heroupdate=new Hero(name,hp,armor,moveSpeed);
        System.out.println(heroupdate);
        if(heroService.updateHeroByName(heroupdate)>0){
            return 1;
        }else {
            return -1;
        }
    }
    @RequestMapping("/deleteHeroByName")
    @ResponseBody
    public int deleteHeroByName(@RequestParam("name") String name){
        Hero herodel=new Hero();
        herodel.setName(name);
        if(heroService.deleteHero(herodel)>0){
            System.out.println("删除成功");
            return 1;
        }else{
            System.out.println("删除失败");
            return -1;
        }
    }
    @RequestMapping("/getAllPlayer")
    @ResponseBody
    public  Collection apiGetAllPlayer(){
        Collection<Player> playerCollection= playerService.selectAllPlayer();
        return playerCollection;
    }
    @RequestMapping("/selectPlayerById")
    @ResponseBody
    public Player apiGetPlayerById(@RequestParam("id") Integer id){
        Player playersel=new Player();
        playersel.setId(id);
        if(playerService.selectPlayerById(playersel)==null){
            System.out.println("查无此玩家");
            Player playernotfound=new Player();
            playernotfound.setId(404);
            return playernotfound;
        }
        else {
            //Object json;
            return playerService.selectPlayerById(playersel);
        }

    }
    @RequestMapping("/addPlayer")
    @ResponseBody
    public int apiAddPlayer(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("degree") Integer degree, @RequestParam("playhero") String playhero) {
        Hero herocheck=new Hero();
        herocheck.setName(playhero);
        try {
            if (heroService.selectHeroByName(herocheck) == null) {
                System.out.println("英雄库不存在英雄" + herocheck.getName() + "添加玩家失败");
                return -1;
            } else {
                Player player = new Player(id, name, degree, playhero);
                playerService.addPlayer(player);
                return 1;
            }
        }catch (Exception e){
            return -1;
        }
    }
    @RequestMapping("/updatePlayerById")
    @ResponseBody
    public int updatePlayerById(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("degree") Integer degree, @RequestParam("playhero") String playhero){
        Player player=new Player(id,name,degree,playhero);
        System.out.println(playhero);
        Hero hero=new Hero();
        hero.setName(playhero);
        if(heroService.selectHeroByName(hero)==null){
            System.out.println("英雄库不存在英雄" + hero.getName() + "更新玩家失败");
            return -1;
        }
//        Collection heros=heroService.selectAllHero();
//        System.out.println(heros);
//        model.addAttribute("heros",heros);
        System.out.println(playerService.updatePlayerById(player));
//        return "dealResult";
        if(playerService.updatePlayerById(player)>0){
            return 1;
        }else {
            return -1;
        }
    }
    @RequestMapping("/deletePlayerById")
    @ResponseBody
    public int deletePlayer(@RequestParam("id") Integer id){
        Player playerdel=new Player();
        playerdel.setId(id);
        if(playerService.deletePlayer(playerdel)>0){
            System.out.println("删除成功");
            return 1;
        }
        else {
            System.out.println("删除失败");
            return -1;
        }
    }
    @RequestMapping("/modify")
    @ResponseBody
    public int modify(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("prepassword")String prepassword){
        if(loginInfoService.checkAll(username,prepassword)==1) {
            System.out.println(loginInfoService.updateUser(username,password));
            return 1;
        }else{
            return -1;
        }
    }
    @RequestMapping("/register")
    @ResponseBody
    public int registerEnd(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username+" "+password);
        try {
            loginInfoService.addUser(username, password);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public int checkAll(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        //System.out.println(username);
        //System.out.println(password);
        if(username==null||password==null){
            return -1;
        } else if(loginInfoService.checkAll(username,password)==1) {
            Cookie cookie=new Cookie("JSESSIONID", session.getId());
            sessionMap.put(cookie.getValue(),username);
            response.addCookie(cookie);


            return 1;
        }
        else{
            return -1;
        }
    }
    @RequestMapping("/loginFail")
    @ResponseBody
    public int loginFail(){
        return 2;
    }
    @RequestMapping("/loginOut")
    @ResponseBody
    public int loginOut(HttpServletRequest request){
        System.out.println("注销时，浏览器的Cookies");
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies) {
            System.out.println(cookie.getValue());
        }
        for(Cookie cookie:cookies) {
            InterfaceController.sessionMap.remove(cookie.getValue());
        }
        System.out.println("删除后的本地Session");
        for(Cookie cookie:cookies) {
            System.out.println(InterfaceController.sessionMap);
        }
        return 1;
    }
}
