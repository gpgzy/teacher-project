package com.example.teacherproject.service;

import com.example.teacherproject.entity.Hobby;
import com.example.teacherproject.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;

    /**
     *更改方向的权重
     * @param hid
     * @param weight
     * @return
     */
    public Hobby updateWeightById(int hid,double weight){
        hobbyRepository.updateWeight(weight,hid);
        return hobbyRepository.findById(hid);
    }

    /**
     *列出所有的方向
     * @return
     */
    public List<Hobby> listHobby(){
        return hobbyRepository.findAll();
    }
}
