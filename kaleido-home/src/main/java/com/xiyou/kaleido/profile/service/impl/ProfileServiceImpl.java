package com.xiyou.kaleido.profile.service.impl;

import com.xiyou.kaleido.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiyou.kaleido.common.util.KaleidoException;
import com.xiyou.kaleido.profile.dao.ProfileDao;
import com.xiyou.kaleido.profile.entity.Profile;
import com.xiyou.kaleido.profile.exception.ProfileError;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DMF on 2017/1/13.
 */

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    public Profile getProfile(String userId) throws KaleidoException {

        Profile profile = profileDao.getProfileByUserId(userId);

        if(profile == null){
            throw new KaleidoException(ProfileError.PROFILE_NOT_EXIST, userId);
        }

        return profile;
    }

    @Transactional
    public long updateProfile(Profile profile) throws KaleidoException {

        if(profile == null){
            throw new KaleidoException(ProfileError.PROFILE_NOT_EXIST);
        }

        return profileDao.updateByUserId(profile);
    };
}
