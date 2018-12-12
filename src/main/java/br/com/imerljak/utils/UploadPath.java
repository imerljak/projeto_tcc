package br.com.imerljak.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UploadPath {

    BASE_PATH(System.getProperty("user.dir") + "/uploads"),
    OUVIDORIAS(BASE_PATH.path + "/ouvidorias/");

    private final String path;
}
