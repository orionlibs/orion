package com.orion.math.geometry.trigonometry;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class TrigonometryServiceTest
{
    @Test
    public void test_getSineInRadians1()
    {
        ANumber result = TrigonometryService.getSineInRadians(ANumber.of(0));
        assertTrue(ANumber.of("0").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().divideGET(6));
        assertTrue(ANumber.of("0.5000000000000001").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().divideGET(4));
        assertTrue(ANumber.of("0.7071067811865472").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.halfPI);
        assertTrue(ANumber.of(1).equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(4));
        assertTrue(ANumber.of("0.7071067811865476").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(6));
        assertTrue(ANumber.of("0.5000000000000003").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue());
        assertTrue(ANumber.of("0.00000000000000012246467991473532").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(6));
        assertTrue(ANumber.of("-0.4999999999999997").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(4));
        assertTrue(ANumber.of("-0.7071067811865477").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(2));
        assertTrue(ANumber.of(-1).equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(4));
        assertTrue(ANumber.of("-0.7071067811865477").equal(result));
    }


    @Test
    public void test_getSineInRadians2()
    {
        ANumber result = TrigonometryService.getSineInRadians(ANumber.of(0), 20);
        assertTrue(ANumber.of("0").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().divideGET(6), 20);
        assertTrue(ANumber.of("0.5").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().divideGET(4), 20);
        assertTrue(ANumber.of("0.7071067811865475244").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.halfPI, 20);
        assertTrue(ANumber.of(1).equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(4), 20);
        assertTrue(ANumber.of("0.7071067811865475244").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(6), 20);
        assertTrue(ANumber.of("0.5").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue(), 20);
        assertTrue(ANumber.of(0).equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(6), 20);
        assertTrue(ANumber.of("-0.5").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(4), 20);
        assertTrue(ANumber.of("-0.7071067811865475244").equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(2), 20);
        assertTrue(ANumber.of(-1).equal(result));
        result = TrigonometryService.getSineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(4), 20);
        assertTrue(ANumber.of("-0.7071067811865475244").equal(result));
    }


    @Test
    public void test_getSineInDegrees()
    {
        ANumber result = TrigonometryService.getSineInDegrees(ANumber.of(0));
        assertTrue(ANumber.of("0").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(30));
        assertTrue(ANumber.of("0.5000000000000001").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(45));
        assertTrue(ANumber.of("0.7071067811865472").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(90));
        assertTrue(ANumber.of(1).equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(135));
        assertTrue(ANumber.of("0.7071067811865476").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(150));
        assertTrue(ANumber.of("0.5000000000000003").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(180));
        assertTrue(ANumber.of("0.00000000000000012246467991473532").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(210));
        assertTrue(ANumber.of("-0.4999999999999997").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(225));
        assertTrue(ANumber.of("-0.7071067811865477").equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(270));
        assertTrue(ANumber.of(-1).equal(result));
        result = TrigonometryService.getSineInDegrees(ANumber.of(315));
        assertTrue(ANumber.of("-0.7071067811865477").equal(result));
    }


    @Test
    public void test_getHyperbolicSineInRadians()
    {
        ANumber result = TrigonometryService.getHyperbolicSineInRadians(ANumber.of(0));
        assertTrue(ANumber.of("0").equal(result));
        result = TrigonometryService.getHyperbolicSineInRadians(ANumber.of(0), 20);
        assertTrue(ANumber.of("0").equal(result));
        result = TrigonometryService.getHyperbolicSineInRadians(Constants.PI.getValue().divideGET(6));
        assertTrue(ANumber.of("0.5478534738880401").equal(result));
        result = TrigonometryService.getHyperbolicSineInRadians(Constants.PI.getValue().divideGET(6), 20);
        assertTrue(ANumber.of("0.54785347388803980848").equal(result));
        result = TrigonometryService.getHyperbolicSineInRadians(ANumber.of(30));
        assertTrue(ANumber.of("5343237290762.231").equal(result));
        result = TrigonometryService.getHyperbolicSineInRadians(ANumber.of(30), 20);
        assertTrue(ANumber.of("5343237290762.23107349523596791649").equal(result));
    }


    @Test
    public void test_getCosineInRadians()
    {
        ANumber result = TrigonometryService.getCosineInRadians(ANumber.of(0));
        assertTrue(ANumber.of(1).equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().divideGET(6));
        assertTrue(ANumber.of("0.8660254037844386").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().divideGET(4));
        assertTrue(ANumber.of("0.7071067811865478").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.halfPI);
        assertTrue(ANumber.of("-0.00000000000000038285686989269494").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(4));
        assertTrue(ANumber.of("-0.7071067811865475").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(6));
        assertTrue(ANumber.of("-0.8660254037844385").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue());
        assertTrue(ANumber.of("-1").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(6));
        assertTrue(ANumber.of("-0.8660254037844388").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(5).divideGET(4));
        assertTrue(ANumber.of("-0.7071067811865474").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(3).divideGET(2));
        assertTrue(ANumber.of("-0.00000000000000018369701987210297").equal(result));
        result = TrigonometryService.getCosineInRadians(Constants.PI.getValue().multiplyGET(7).divideGET(4));
        assertTrue(ANumber.of("0.7071067811865474").equal(result));
    }


    @Test
    public void test_getArcsineAsDegrees()
    {
        ANumber result = TrigonometryService.getArcsineAsDegrees(ANumber.of(0));
        assertTrue(ANumber.of(0).equal(result));
        result = TrigonometryService.getArcsineAsDegrees(ANumber.of(0.5));
        assertTrue(ANumber.of(
                        "30.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000190985931710274402922660516047017234441351574888547738497200812870676157161071842108136563319503703147287411272109549644271494215337494383453560892878039807075087960324890893087693295676310369226460871475460877194032034868290068354814198856137067239706859128554268104283208747344587293124325412902634467719935732080298406817287351533077987716139689887400383755365639338382625457889743880357089246795048967218331980641719039954931450702205414630117341022521")
                        .equal(result));
        result = TrigonometryService.getArcsineAsDegrees(ANumber.of(1));
        assertTrue(ANumber.of(90).equal(result));
    }
}