package com.ayasakinui.twitterservice.service;

import java.net.http.WebSocket.Listener;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayasakinui.twitterservice.dataAccess.entity.*;
import com.ayasakinui.twitterservice.dataAccess.repository.*;


@Service
public class memberdomService {
    /**
   * ユーザー情報 Repository
   */
  @Autowired
  private MemberdomRepository MemberdomRepository;  

    /**
   * dom ユーザー情報 
   * @return 検索結果
   */
  public List<Long> findMemberIds(Long domId) {
        List<MemberDom> memberDomList= MemberdomRepository.findBydomId(domId); //domに所属するmemberを取得
         List<Long> memberIds = new ArrayList<Long>();

         for (int i=0; i<=memberDomList.size(); i++) {
             memberIds.add(memberDomList.get(i).getMemberId());
         }

         return memberIds;
  }

  public List<Optional> findMembers(List<Long> memberIds){
      List<Optional> memberList = new ArrayList<Optional>();

      for (int i=0; i<=memberIds.size(); i++) {
        memberList.add(MemberRepository.findById(memberIds.get(i)));
    }
    return memberList;
  }
}
