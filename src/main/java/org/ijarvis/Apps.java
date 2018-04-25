package org.ijarvis;

/**
 * Created by liuwenru on 2017/2/20.
 */
//@Controller
//
//public class Apps {
//    private static final Logger logger=Logger.getLogger(Apps.class);
//    @RequestMapping("/res/asasas}")
//    public String hello(HttpSession session) throws IOException, InterruptedException {
//        logger.error("aaaaaaa");
//        logger.debug("-------"+session.getAttribute("sec"));
//        if (session.getAttribute("sec")==null){
//            logger.debug("exec here...........");
//            session.setAttribute("sec",1000);
//        }
//        logger.debug(session.getAttribute("sec"));
//        Thread.sleep(Long.parseLong(String.valueOf(Long.parseLong(session.getAttribute("sec").toString()))));
//        int count =0;
//        while (count< 100000){
//            logger.debug(count);
//        }
//        return "hello";
//    }
//    @RequestMapping("/sec")
//    public String setSec(@RequestParam(value = "sec") String sec,HttpSession session){
//        session.setAttribute("sec",sec);
//        logger.debug(session.getAttribute("sec"));
//        return  "hello";
//    }
//    @RequestMapping("/exp")
//    public void exp() throws IOException {
//        throw new IOException();
//    }
//    @RequestMapping("/redi")
//    public  String redic() {
//        return "redirect:/index";
//    }
//}
