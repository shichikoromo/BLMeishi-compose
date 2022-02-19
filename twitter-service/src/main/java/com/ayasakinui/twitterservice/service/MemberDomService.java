package com.ayasakinui.twitterservice.service;

import com.ayasakinui.twitterservice.dataAccess.entity.MemberDom;
import com.ayasakinui.twitterservice.dataAccess.repository.MemberRepository;
import com.ayasakinui.twitterservice.dataAccess.repository.MemberDomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MemberDomService {
    /**
   * ユーザー情報 Repository
   */
  @Autowired
  private MemberDomRepository memberdomRepository;
  private MemberRepository memberRepository;


    /**
   * dom ユーザー情報 
   * @return 検索結果
   */
  public List<Long> findMemberIds(Long domId) {
        List<MemberDom> memberDomList= memberdomRepository.findBydomId(domId); //domに所属するmemberを取得
         List<Long> memberIds = new ArrayList<Long>();

         for (int i=0; i<=memberDomList.size(); i++) {
             memberIds.add(memberDomList.get(i).getMemberId());
         }

         return memberIds;
  }

  public List<Optional> findMembers(List<Long> memberIds){
      List<Optional> memberList = new ArrayList<Optional>();

      for (int i=0; i<=memberIds.size(); i++) {
        memberList.add(memberRepository.findById(memberIds.get(i)));
    }
    return memberList;
  }
}
