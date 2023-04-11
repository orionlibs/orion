package com.orion.math.linearalgebra;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class LinearAlgebraServiceTest
{
    @Test
    public void testSolveSystemOfLinearEquationsUsingGaussJordanElimination()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(1), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(6), ANumber.of(8)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(8), ANumber.of(18)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix coefficients = Matrix.of(elements);
        Vector constants = Vector.of(1, 3, 5);
        Vector result = LinearAlgebraService.solveSystemOfLinearEquationsUsingGaussJordanElimination(coefficients, constants);
        ANumber[] solutionElements = new ANumber[3];
        solutionElements[0] = ANumber.of("0.30000000000000000750000000000000018750000000000000581390000000000015801950000000000426728750000000011546726270000000314199279839999997486405761280000020108753867");
        solutionElements[1] = ANumber.of("0.400000000000000004500000000000000112500000000000003119700000000000090664500000000002456692500000000066405242100000001801639276200000018851956790399999849184346");
        solutionElements[2] = ANumber.of("-0.0000000000000000045000000000000001125000000000000033245000000000000929685000000000025142925000000000680025285000000018480595");
        Vector expected = Vector.of(solutionElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void testSolveSystemOfLinearEquationsUsingQRDecomposition()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(1), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(6), ANumber.of(8)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(8), ANumber.of(18)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix coefficients = Matrix.of(elements);
        Vector constants = Vector.of(1, 3, 5);
        Vector result = LinearAlgebraService.solveSystemOfLinearEquationsUsingQRDecomposition(coefficients, constants);
        ANumber[] solutionElements = new ANumber[3];
        solutionElements[0] = ANumber.of(
                        "0.29999999999999985139198677983842766367796272583082872841212811197401582472801328011820783703427048282386791619241405460975203439224455808627372078287451430772472329485081178877155892023020674669673172704453669435645707673824594568865795023785957608220479892478315133514479558087348651562810827351524966951996396222725705961901878324934968038841741497220133680432315749267968604677589893579098777108860547936110373444806470254381852102168012301019291504629365375182984433670704318741425385193762025022252010591630729331913229341448516299528290831245162185089797640935787323432703985691957980328698171849582449099164319255859207233888750124185058184823891953595801406334481152135395062732069553826751131685572683039666256034030884799304864777370884134885335822736416216852475609694277225729248785813204976562892494677629707779555294845672469870749914468043195509885731302389798349859472465550254765006448131077259152706238466017511982485498645147007044498823510641750007320240215707526375829269739622936827454");
        solutionElements[1] = ANumber.of(
                        "0.39999999999999992654153221868943358765345362431196175504636045821591099681399213924361691672061943984768190758634234025353862465978972046302966014555257912282972340036545098432925369616543994680689067294199306394427917461118015929632381685317065501180853731996531263286555088560508158989403200262485166730250929820188452026778563487612228433122709705340768576184268817049306707880994743643039884632445121479984526127740819220721175162780405989594666465871020194952950102015944279369505569186759312857774047301312846778491588882066609918544886781726108419948319794197544618211120724344215602285598849409217314785730923448235231787530590343726741087304734011496233039104097053585045287554013585349196854483336395155888568944054189906480730265343067543306004433486285004128845172702403996181975228414866027116473871945366041018855209784960829101787137950555546739105463762613798689284622823256795322474679352525241556083925847759160190502959537");
        solutionElements[2] = ANumber.of(
                        "0.00000000000000007609344317797203765619936168291695829307647614823749307586856947186203157384040547094772918960647782569270937781322464213117547995475822741015618328840398213903845753492105445383734120331712158431818783644844129502470439562271093481138185664720283763129098467852048864881138646886933536503351684589876295562838016686216663401208294521614318414952710506462189354665272497863747542597524699852759440575486692190271214914068598694925998619682967907346570332095905066830713918479985808618723392616370020570351459551520829182258330391163556377064712474561732379409826303254125042286251088693473081416196241037578487577487280807206031140085042162702250385623019897426884665615976819136837044110481926327240226465444006058225291195003857973");
        Vector expected = Vector.of(solutionElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void testDoForwardSubstitution()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-1), ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(-2), ANumber.of(-1), ANumber.of(0)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-2), ANumber.of(6), ANumber.of(2)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        elements.append(vector4);
        Matrix coefficients = Matrix.of(elements);
        Vector constants = Vector.of(5, 6, 4, 2);
        Vector result = LinearAlgebraService.doForwardSubstitution(coefficients, constants);
        ANumber[] solutionElements = new ANumber[4];
        solutionElements[0] = ANumber.of("1.6666666666666667");
        solutionElements[1] = ANumber.of("7.6666666666666667");
        solutionElements[2] = ANumber.of("-14.3333333333333333");
        solutionElements[3] = ANumber.of("50.8333333333333332");
        Vector expected = Vector.of(solutionElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void testDoBackwardSubstitution()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(-1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(-2), ANumber.of(7), ANumber.of(-4)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(6), ANumber.of(5)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0), ANumber.of(3)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        elements.append(vector4);
        Matrix coefficients = Matrix.of(elements);
        Vector constants = Vector.of(20, -7, 4, 6);
        Vector result = LinearAlgebraService.doBackwardSubstitution(coefficients, constants);
        ANumber[] solutionElements = new ANumber[4];
        solutionElements[0] = ANumber.of(3);
        solutionElements[1] = ANumber.of(-4);
        solutionElements[2] = ANumber.of(-1);
        solutionElements[3] = ANumber.of(2);
        Vector expected = Vector.of(solutionElements);
        assertTrue(expected.equals(result));
    }
}