package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.DocAdminstratifJoindre;
import com.YadouSoft.gestionRH.models.Image;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.repositories.DocAdministratifJoindreRepository;
import com.YadouSoft.gestionRH.repositories.ImageRepository;
import com.YadouSoft.gestionRH.services.DocAdministratifJoindreService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "docAdmin/image")
public class DocAdministratifJoindreController {
    @Autowired
    SalarieService salarieService;
    @Autowired
    DocAdministratifJoindreService docAdministratifJoindreService;
    @Autowired
    DocAdministratifJoindreRepository docAdministratifJoindreRepository;
    @Autowired
    ImageRepository imageRepository;
    @PostMapping("/upload")

    public void uplaodImage(
            @RequestParam("copieCINE") MultipartFile copieCINE,
            @RequestParam("copieCNSS") MultipartFile copieCNSS,
            @RequestParam("copieDiplomes") MultipartFile copieDiplomes,
            @RequestParam("fichAnthropométrique") MultipartFile fichAnthropométrique,
            @RequestParam("radiographiePulmonaire") MultipartFile radiographiePulmonaire,
            @RequestParam("salarie_id")String salarie_id) throws IOException {


        Image img2 = new Image(copieCINE.getOriginalFilename(), copieCINE.getContentType(),
                docAdministratifJoindreService.compressBytes(copieCINE.getBytes()));

        Image img3 = new Image(copieCNSS.getOriginalFilename(), copieCNSS.getContentType(),
                docAdministratifJoindreService.compressBytes(copieCNSS.getBytes()));

        Image img4 = new Image(copieDiplomes.getOriginalFilename(), copieDiplomes.getContentType(),
                docAdministratifJoindreService.compressBytes(copieDiplomes.getBytes()));

        Image img5 = new Image(fichAnthropométrique.getOriginalFilename(), fichAnthropométrique.getContentType(),
                docAdministratifJoindreService.compressBytes(fichAnthropométrique.getBytes()));

        Image img6 = new Image(radiographiePulmonaire.getOriginalFilename(), radiographiePulmonaire.getContentType(),
                docAdministratifJoindreService.compressBytes(radiographiePulmonaire.getBytes()));
        imageRepository.save(img2);
        imageRepository.save(img3);
        imageRepository.save(img4);
        imageRepository.save(img5);
        imageRepository.save(img6);
        DocAdminstratifJoindre docAdminstratifJoindre=new DocAdminstratifJoindre();
        docAdminstratifJoindre.setPicByteCINE(img2.getPicByte());
        docAdminstratifJoindre.setCopieCINE(img2.getName());
        docAdminstratifJoindre.setPicByteCNSS(img3.getPicByte());
        docAdminstratifJoindre.setCopieCarteCNSS(img3.getName());
        docAdminstratifJoindre.setPicByteDiplome(img4.getPicByte());
        docAdminstratifJoindre.setCopieDiplome(img4.getName());
        docAdminstratifJoindre.setPicByteFichAnthropométrique(img5.getPicByte());
        docAdminstratifJoindre.setFichAnthropométrique(img5.getName());
        docAdminstratifJoindre.setPicByteRadiographiePulmonaire(img6.getPicByte());
        docAdminstratifJoindre.setRadiographiePulmonaire(img6.getName());
        docAdminstratifJoindre.setSalarie(salarieService.getSalarieById(Long.valueOf(salarie_id)));

        docAdministratifJoindreRepository.save(docAdminstratifJoindre);



    }

    @GetMapping(path = { "/get/{imageFile}" },produces = MediaType.APPLICATION_JSON_VALUE)
    public Image getImage(@PathVariable("imageFile") String imageName){

        final Optional<Image> retrievedImage = imageRepository.findImageByName(imageName);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                docAdministratifJoindreService.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    @GetMapping(path = { "/docs" })
    public @ResponseBody List<DocAdminstratifJoindre> getDocs() {
        return docAdministratifJoindreRepository.findAll();
    }



}
