package hotel.swap.demo.action;

import hotel.swap.demo.service.IndexService;
import hotel.swap.demo.service.ReloadService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.mapping.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
@Controller
public class IndexController {

    @Autowired
    private ReloadService reloadService;

    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("demo", indexService.hello());
        return "index";
    }

    @RequestMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws Exception {
        reloadService.reload(file.getBytes(), file.getOriginalFilename());
        return "index";
    }

}
