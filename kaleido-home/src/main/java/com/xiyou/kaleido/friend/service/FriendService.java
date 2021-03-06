package com.xiyou.kaleido.friend.service;

import com.xiyou.kaleido.common.exception.KaleidoException;
import com.xiyou.kaleido.friend.entity.Friend;
import com.xiyou.kaleido.profile.entity.Profile;

import java.util.List;

/**
 * Created by chad.ding on 2017/2/8.
 */
public interface FriendService {
    void addFriend(String owner, String objective) throws KaleidoException;

    Friend getFriend(String owner, String objective) throws KaleidoException;

    List<Friend> getFriendList(Friend friend) throws KaleidoException;

    void updateFriend(Friend friend) throws KaleidoException;
}
