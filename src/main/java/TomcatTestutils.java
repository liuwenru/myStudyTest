import org.apache.catalina.connector.CoyoteOutputStream;
import org.apache.catalina.connector.OutputBuffer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TomcatTestutils {
    public static void main(String[] args) throws IOException {
        String s=new String("[{ \"title\":\"待办事宜(1967)\",\"items\":[{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=d3f67ba0-9415-4331-ac57-9a7c707c77e1','popdiv','待办事宜','','');return false;★ title=★【工作提醒】姚宇多标段单一文件生成测试项目01★>【工作提醒】姚宇多标段单一文件生成测试项目01</span>\",\"date\":\"2018-06-25\",\"option\":\"<i onclick=★RemindClick('message_wait','d3f67ba0-9415-4331-ac57-9a7c707c77e1')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('huiyuaninfomis2/pages/FrameAll?ProcessVersionInstanceGuid=0ab260ef-e286-4dbd-89d5-f2ca2438f56b&WorkItemGuid=0c9fdcd1-981d-4ac8-90c7-21fcbc75fe04','popdiv','待办事宜','','');return false;★ title=★【诚信库提交】<未提交的主体诚信库验证>★>【诚信库提交】<未提交的主体诚信库验证></span>\",\"date\":\"2018-06-15\",\"option\":\"<i onclick=★RemindClick('message_wait','da3bd9dd-8b9e-4a25-a02e-562b778a5aeb')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('customframe4bid/pages/workflow/Handle_Main?ProcessVersionInstanceGuid=1f56447c-b1a3-4a3c-9d61-418369e368bc&WorkItemGuid=c4962947-14bf-4c90-aac3-478099053905','popdiv','待办事宜','','');return false;★ title=★【退回】项目注册:CYQ524挂牌1！@#￥%……&*（）——+~：“《》，。<>★>【退回】项目注册:CYQ524挂牌1！@#￥%……&*（）——+~：“《》，。<></span>\",\"date\":\"2018-06-12\",\"option\":\"<i onclick=★RemindClick('message_wait','1f4a63bd-be59-4292-b2b3-36c0df7806ad')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('customframe4bid/pages/workflow/Handle_Main?ProcessVersionInstanceGuid=ac37fcef-ef02-47df-b0f2-061c1407487d&WorkItemGuid=5ac0f510-7090-4519-be12-075f4d3282fd','popdiv','待办事宜','','');return false;★ title=★【退回】招标文件备案:测试建设工程工作台0521-测试建设工程工作台0521-02★>【退回】招标文件备案:测试建设工程工作台0521-测试建设工程工作台0521-02</span>\",\"date\":\"2018-06-12\",\"option\":\"<i onclick=★RemindClick('message_wait','1aa11b20-12e2-4763-b0f2-e9259ad13eb7')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=1e8c679e-f116-4c91-aa07-dc57802580f8','popdiv','待办事宜','','');return false;★ title=★【工作提醒】★>【工作提醒】</span>\",\"date\":\"2018-06-08\",\"option\":\"<i onclick=★RemindClick('message_wait','1e8c679e-f116-4c91-aa07-dc57802580f8')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=c401237d-770b-44a1-b477-12a067753e5e','popdiv','待办事宜','','');return false;★ title=★【工作提醒】★>【工作提醒】</span>\",\"date\":\"2018-06-08\",\"option\":\"<i onclick=★RemindClick('message_wait','c401237d-770b-44a1-b477-12a067753e5e')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=620f1e58-c047-4c9f-8b3f-6c39d64d2cd2','popdiv','待办事宜','','');return false;★ title=★【工作提醒】测试项目002★>【工作提醒】测试项目002</span>\",\"date\":\"2018-06-05\",\"option\":\"<i onclick=★RemindClick('message_wait','620f1e58-c047-4c9f-8b3f-6c39d64d2cd2')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=f3d41423-68fa-452c-8399-d2956b481e0b','popdiv','待办事宜','','');return false;★ title=★【工作提醒】测试建设工程工作台0521★>【工作提醒】测试建设工程工作台0521</span>\",\"date\":\"2018-05-23\",\"option\":\"<i onclick=★RemindClick('message_wait','f3d41423-68fa-452c-8399-d2956b481e0b')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=1ad225b1-6ab0-49dd-b7d5-a88146925190','popdiv','待办事宜','','');return false;★ title=★【工作提醒】czy多标段测试0521★>【工作提醒】czy多标段测试0521</span>\",\"date\":\"2018-05-22\",\"option\":\"<i onclick=★RemindClick('message_wait','1ad225b1-6ab0-49dd-b7d5-a88146925190')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=e75e457b-317a-4683-8752-a37da2518fd2','popdiv','待办事宜','','');return false;★ title=★【工作提醒】测试建设工程工作台0521★>【工作提醒】测试建设工程工作台0521</span>\",\"date\":\"2018-05-22\",\"option\":\"<i onclick=★RemindClick('message_wait','e75e457b-317a-4683-8752-a37da2518fd2')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('customframe4bid/pages/workflow/Handle_Main?ProcessVersionInstanceGuid=5b5931d1-8313-4d74-af4f-832d96d3dd7a&WorkItemGuid=872a5e56-b569-4a11-864e-b3d6f62d2ed3','popdiv','待办事宜','','');return false;★ title=★【代理提交】<未提交的建设工程更正公告备案>★>【代理提交】<未提交的建设工程更正公告备案></span>\",\"date\":\"2018-05-22\",\"option\":\"<i onclick=★RemindClick('message_wait','45f6535a-eeb5-4669-83b3-48a6974efc71')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('customframe4bid/pages/workflow/Handle_Main?ProcessVersionInstanceGuid=c403c5a4-84c8-4f31-8d94-648478478d68&WorkItemGuid=387f5fc3-831e-40ea-b4d8-49c7598499b2','popdiv','待办事宜','','');return false;★ title=★【提交申请】<未提交的建设工程资格预审审核流程>★>【提交申请】<未提交的建设工程资格预审审核流程></span>\",\"date\":\"2018-05-14\",\"option\":\"<i onclick=★RemindClick('message_wait','f516de32-6a2b-416a-8696-f05256e1ef70')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('zhmanagemis/mainpages/WaitHandleInfoGeneral?infoguid=974519a9-2c90-46c6-a718-489906414585','popdiv','待办事宜','','');return false;★ title=★【工作提醒】★>【工作提醒】</span>\",\"date\":\"2018-05-10\",\"option\":\"<i onclick=★RemindClick('message_wait','974519a9-2c90-46c6-a718-489906414585')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('huiyuaninfomis2/pages/FrameAll?ProcessVersionInstanceGuid=b434e31c-9b68-47f8-81e0-a316f26a5e37&WorkItemGuid=79d351b6-525c-420f-93fb-a681b04a11df','popdiv','待办事宜','','');return false;★ title=★【诚信库提交】<未提交的主体诚信库验证>★>【诚信库提交】<未提交的主体诚信库验证></span>\",\"date\":\"2018-05-07\",\"option\":\"<i onclick=★RemindClick('message_wait','0b581bbc-c8bf-46ff-b658-482a57e5bdc3')★></i>\"},{\"title\":\"<span onclick=★javascript:openWindowAuto('huiyuaninfomis2/pages/FrameAll?ProcessVersionInstanceGuid=33d252fe-7755-46e4-a173-b8316aaffa33&WorkItemGuid=32001d96-f2df-45a1-b263-632613a69b5c','popdiv','待办事宜','','');return false;★ title=★【诚信库提交】<未提交的主体诚信库验证>★>【诚信库提交】<未提交的主体诚信库验证></span>\",\"date\":\"2018-05-07\",\"option\":\"<i onclick=★RemindClick('message_wait','52a62497-9ea0-4232-88eb-27ab48d2f854')★></i>\"}]}]");
        OutputBuffer b=new OutputBuffer();
    }
}