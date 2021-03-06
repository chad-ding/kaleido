package com.xiyou.kaleido.album.controller;

import com.xiyou.kaleido.common.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.xiyou.kaleido.common.annotation.KaleidoController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chad.ding on 2017/1/10.
 */

@Controller
@KaleidoController
@RequestMapping(value="/api/album")
public class AlbumController {

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public ResponseEntity<ResponseModel> uploadImage(@RequestParam("file") CommonsMultipartFile image, @RequestParam String uuid, HttpServletRequest request, HttpServletResponse response){

        return new ResponseEntity<ResponseModel>(new ResponseModel("success"), HttpStatus.OK);
    }
}
