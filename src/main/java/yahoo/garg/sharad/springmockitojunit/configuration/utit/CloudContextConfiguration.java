/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahoo.garg.sharad.springmockitojunit.configuration.utit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import yahoo.garg.sharad.springmockitojunit.util.Profiles;

/**
 *
 * @author Sharad Garg
 *         Created on Oct 3, 2017 1:03:45 PM
 */
@Configuration
@Profile(Profiles.UTIT)
public class CloudContextConfiguration {

}
