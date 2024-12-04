package br.com.alura.literalura.service;

import java.util.List;

public interface IDataConverter {

    <T> T convert(String json, Class<T> tClass);

    <T> List<T> convertList(String json, Class<T> tClass);
}
