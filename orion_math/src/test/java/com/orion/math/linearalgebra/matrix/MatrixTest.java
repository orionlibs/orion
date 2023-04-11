package com.orion.math.linearalgebra.matrix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.decomposition.CholeskyDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.LUDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.QRDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.SingularValueDecomposition;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class MatrixTest
{
    @Test
    public void testGetDeterminant()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(0).equals(matrix1.getDeterminant()));
    }


    @Test
    public void testAdd()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elements2 = OrionArrayList.of();
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(6)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8)});
        elements2.append(vector3);
        elements2.append(vector4);
        Matrix matrix2 = Matrix.of(elements2);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(8)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(10), ANumber.of(12)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.add(matrix2)));
    }


    @Test
    public void testSubtract()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elements2 = OrionArrayList.of();
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(6)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8)});
        elements2.append(vector3);
        elements2.append(vector4);
        Matrix matrix2 = Matrix.of(elements2);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(-4), ANumber.of(-4)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(-4), ANumber.of(-4)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.subtract(matrix2)));
    }


    @Test
    public void testMultiply()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(6)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(9), ANumber.of(12)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.multiply(ANumber.of(3))));
    }


    @Test
    public void testMultiply2()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elements2 = OrionArrayList.of();
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(6)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8)});
        elements2.append(vector3);
        elements2.append(vector4);
        Matrix matrix2 = Matrix.of(elements2);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(19), ANumber.of(22)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(43), ANumber.of(50)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.multiply(matrix2)));
    }


    @Test
    public void testMultiplyRowGET()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(9), ANumber.of(12)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.multiplyRowGET(1, ANumber.of(3))));
    }


    @Test
    public void testMultiplyColumnGET()
    {
        OrionList<Vector> elements1 = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(4)});
        elements1.append(vector1);
        elements1.append(vector2);
        Matrix matrix1 = Matrix.of(elements1);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vectorExpected1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(6)});
        Vector vectorExpected2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(12)});
        elementsExpected.append(vectorExpected1);
        elementsExpected.append(vectorExpected2);
        Matrix matrixExpected = Matrix.of(elementsExpected);
        assertTrue(matrixExpected.equals(matrix1.multiplyColumnGET(1, ANumber.of(3))));
    }


    @Test
    public void testGetLUDecomposition()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(9), ANumber.of(3), ANumber.of(6)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(6), ANumber.of(1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(7)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elementsLower = OrionArrayList.of();
        Vector vectorLower1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        Vector vectorLower2 = Vector.of(new ANumber[]
        {ANumber.of("0.44444444444444444"), ANumber.of(1), ANumber.of(0)});
        Vector vectorLower3 = Vector.of(new ANumber[]
        {ANumber.of("0.11111111111111111"), ANumber.of("0.142857142857142857448979591836734693"), ANumber.of(1)});
        elementsLower.append(vectorLower1);
        elementsLower.append(vectorLower2);
        elementsLower.append(vectorLower3);
        Matrix matrixLower = Matrix.of(elementsLower);
        OrionList<Vector> elementsUpper = OrionArrayList.of();
        Vector vectorUpper1 = Vector.of(new ANumber[]
        {ANumber.of(9), ANumber.of(3), ANumber.of(6)});
        Vector vectorUpper2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of("4.66666666666666668"), ANumber.of("-1.66666666666666664")});
        Vector vectorUpper3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of("6.57142857142857143193877551020408162302721088435374152")});
        elementsUpper.append(vectorUpper1);
        elementsUpper.append(vectorUpper2);
        elementsUpper.append(vectorUpper3);
        Matrix matrixUpper = Matrix.of(elementsUpper);
        LUDecomposition result = matrix1.getLUDecomposition();
        assertTrue(matrixLower.equals(result.getLower()));
        assertTrue(matrixUpper.equals(result.getUpper()));
    }


    @Test
    public void testGetQRDecomposition()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(12), ANumber.of(-51), ANumber.of(4)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(167), ANumber.of(-68)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(-4), ANumber.of(24), ANumber.of(-41)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elementsQ = OrionArrayList.of();
        Vector vectorQ1 = Vector.of(new ANumber[]
        {ANumber.of("-0.857142857142857154"), ANumber.of("0.39428571428571428507159054097899755061934070680344"),
                        ANumber.of("-0.33142857142857142849022780172712145421909448844799298869070639424677026537473901876434198414386487958649155694486801446297482602152381159208101276044622492561429357696719712998682675509347733975044864804832723274759006020742387625795506057")});
        Vector vectorQ2 = Vector.of(new ANumber[]
        {ANumber.of("-0.428571428571428574"), ANumber.of("-0.90285714285714285652508036181659353162677944018936"),
                        ANumber.of("0.03428571428571428660574549018630651132484062829440035684180740128013290980733793454715612133990540742341071441350413728669396428854416407002211464811726851175714235565797278524241793804934153140418414469837012314318903457643305943409162233")});
        Vector vectorQ3 = Vector.of(new ANumber[]
        {ANumber.of("0.285714285714285716"), ANumber.of("-0.17142857142857142957284891978789764558214703987376"),
                        ANumber.of("-0.94285714285714285556206516990190459567002252290237843080940808082011143141321015447229177042173652762435859921434783745888353163175518867120986630916277200920716719741463221209685335820641972214506972709742651352798662875762203962272774822")});
        elementsQ.append(vectorQ1);
        elementsQ.append(vectorQ2);
        elementsQ.append(vectorQ3);
        Matrix matrixQ = Matrix.of(elementsQ);
        OrionList<Vector> elementsR = OrionArrayList.of();
        Vector vectorR1 = Vector.of(new ANumber[]
        {ANumber.of(-14), ANumber.of("-21.0000000000000012"), ANumber.of("14.00000000000000012")});
        Vector vectorR2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(-175), ANumber.of("69.9999999999999998932239316239316240678771590979453533207483489")});
        Vector vectorR3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(35)});
        elementsR.append(vectorR1);
        elementsR.append(vectorR2);
        elementsR.append(vectorR3);
        Matrix matrixR = Matrix.of(elementsR);
        QRDecomposition result = matrix1.getQRDecomposition();
        assertTrue(matrixQ.equals(result.getQ()));
        assertTrue(matrixR.equals(result.getR()));
    }


    @Test
    public void testIsCirculantMatrix()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(3), ANumber.of(1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(1), ANumber.of(2)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(matrix1.isCirculantMatrix());
    }


    @Test
    public void testGetSingularValueDecomposition()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(4)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(3)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0)});
        Vector vector4 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        elements.append(vector4);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elementsU = OrionArrayList.of();
        Vector vectorU1 = Vector.of(new ANumber[]
        {ANumber.of("0.81741556047036301409950432842415980862101693565607403599697260886089274415602684618957108484438350984322952652630975739995260946993499688455987048210217472175257043856093818028889332410185872712956375999629375818167142793833721322987324753790495770197941376239959296212927348351855237647853401808176315475809250974784489109966331886380099094323050547554686778945065"),
                        ANumber.of("-0.5760484367663207227169464377022465282517024582451314403192377160069938267292958795748570667392581334304577754922710665495315649598754155467514806558682571909389555390794269364991256971220831166736985561522448495929774255725623368013802089404723374562848102662680941449730128785992849922813444848306329251745760003318892484754689038444452344205317459901616036245013198915599888826843806546093631425574087040458628066518286524775009030702652731330330357901738760716258880123137")});
        Vector vectorU2 = Vector.of(new ANumber[]
        {ANumber.of("0.57604843676632076241615517229166904117081113017005305480631456921884511548987877556055704171036381478389050421743336164437487032503301575927821787861317798298506474368503669754478693807384683462709963224092103751238726252766637240841735472354856145540452299385745708826410471177448714329426861217599835307135430713746133417350865726550935750957624181952656505159955"),
                        ANumber.of("0.8174155604703632363716552095204934912329461373151907160930512648420657190479819839456248222704758302510825317475848944083697044747362251719802204988159121826643950761799489066380223449808354472915206511861691066209971243265154720913797221878885307694208413880114779004974630248165951723567624647763405801978297084684676184991232429488880455594050720074601833828697003201053643007458364266764002811527502429059144083508753213674211586132662551259373462765124043938560608251941")});
        Vector vectorU3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0)});
        Vector vectorU4 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0)});
        elementsU.append(vectorU1);
        elementsU.append(vectorU2);
        elementsU.append(vectorU3);
        elementsU.append(vectorU4);
        Matrix matrixU = Matrix.of(elementsU);
        OrionList<Vector> elementsV = OrionArrayList.of();
        Vector vectorV1 = Vector.of(new ANumber[]
        {ANumber.of("0.40455358483375707016143345867611334276254565140579008358868337815673993214959543493194313318651509433592478180996936134969223688320485974501572888849109857752295783319853542180697224863484548644333573435350501085863556840294957957876391748885691590252415957040321166116854104427682498810661054342367084017360403113"),
                        ANumber.of("-0.9145142956773043813596748219789443594550938464367063794968086974390947549495324698150519197")});
        Vector vectorV2 = Vector.of(new ANumber[]
        {ANumber.of("0.9145142956773043813596748219789443594550938464367063794968086974390947549495324698150519197"), ANumber.of(
                        "0.40455358483375707016143345867611334276254565140579008358868337815673993214959543493194313318651509433592478180996936134969223688320485974501572888849109857752295783319853542180697224863484548644333573435350501085863556840294957957876391748885691590252415957040321166116854104427682498810661054342367084017360403113")});
        elementsV.append(vectorV1);
        elementsV.append(vectorV2);
        Matrix matrixV = Matrix.of(elementsV);
        OrionList<Vector> elementsW = OrionArrayList.of();
        Vector vectorW1 = Vector.of(new ANumber[]
        {ANumber.of("5.464985704219042"), ANumber.of(0)});
        Vector vectorW2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(
                        "0.3659661906262581530309969563708967922988666200599514280626100017162158876575345497817983680372988001451401353521440587292138284636953495100796342290366388739795141352842941387961205965781463244692646453140089670548482285111320686399715436308897194994133563903426836488266606097722479342437285704863638282398315079182232550963625698580901549367207693151513976775085935460561939859539547744533665739212297230400075116520573810592961953317290472164831821797436542626689868529065256260165276620760887759053473625535633631597972949618597410850029637756524270036071373990284498158114937425351234828364525098042053611445933122703288052995654175394839135774563715949282341624335188254")});
        elementsW.append(vectorW1);
        elementsW.append(vectorW2);
        Matrix matrixW = Matrix.of(elementsW);
        SingularValueDecomposition result = matrix1.getSingularValueDecomposition();
        assertTrue(matrixU.equals(result.getU()));
        assertTrue(matrixV.equals(result.getV()));
        assertTrue(matrixW.equals(result.getS()));
    }


    @Test
    public void testGetCholeskyDecomposition()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(12), ANumber.of(-16)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(12), ANumber.of(37), ANumber.of(-43)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(-16), ANumber.of(-43), ANumber.of(98)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elementsL = OrionArrayList.of();
        Vector vectorL1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(0), ANumber.of(0)});
        Vector vectorL2 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(1), ANumber.of(0)});
        Vector vectorL3 = Vector.of(new ANumber[]
        {ANumber.of(-8), ANumber.of(5), ANumber.of(3)});
        elementsL.append(vectorL1);
        elementsL.append(vectorL2);
        elementsL.append(vectorL3);
        Matrix matrixL = Matrix.of(elementsL);
        OrionList<Vector> elementsLTranspose = OrionArrayList.of();
        Vector vectorLTranspose1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(6), ANumber.of(-8)});
        Vector vectorLTranspose2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1), ANumber.of(5)});
        Vector vectorLTranspose3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(3)});
        elementsLTranspose.append(vectorLTranspose1);
        elementsLTranspose.append(vectorLTranspose2);
        elementsLTranspose.append(vectorLTranspose3);
        Matrix matrixLTranspose = Matrix.of(elementsLTranspose);
        CholeskyDecomposition result = matrix1.getCholeskyDecomposition();
        assertTrue(matrixL.equals(result.getL()));
        assertTrue(matrixLTranspose.equals(result.getLTranspose()));
    }


    @Test
    public void testGetInverse()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(4), ANumber.of(-3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(-5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(-8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        Matrix identityMatrix = matrix1.invert().multiply(matrix1);
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vector1Expected = Vector.of(new ANumber[]
        {ANumber.of("1.00000000000000000333333333333333334444444444444444448444316415180615233766828725088581317215322639666484050701899379260070885769336776043777564803"),
                        ANumber.of("-0.00000000000000000000000000000000000012557319223985908312479587170947875737463365776131046209968178025461598791252542109059560927763744050031502632"),
                        ANumber.of("0.00000000000000000000000000000000000000000000000000000004746227709193817646127861295419229676747694910046015893343578177573262696248712056285440461")});
        Vector vector2Expected = Vector.of(new ANumber[]
        {ANumber.of("-0.000000000000000023333333333333333411111111111111111377774577046182048110818180404306817998248797012009796333845880431474379749518304459616946308"),
                        ANumber.of("1.000000000000000000000000000000000000313932980599647709695587562871583140308522220045457519420487138381818756276540256545728841882062239562224352"),
                        ANumber.of("-0.000000000000000000000000000000000000000000000000000000118655692729845441865130688764553393100004952654781074845743690946233951407820019507502396")});
        Vector vector3Expected = Vector.of(new ANumber[]
        {ANumber.of("-0.0000000000000000233333333333333334111111111111111113792554183813443834722470504434061373544736623191924726911"), ANumber.of("0.0000000000000000000000000000000000003767195767195772510486968449932240471211792627436481543401855076485402184"),
                        ANumber.of("0.9999999999999999999999999999999999999999999999999999998576131687241854699833337999115807532252913038953922543")});
        elementsExpected.append(vector1Expected);
        elementsExpected.append(vector2Expected);
        elementsExpected.append(vector3Expected);
        Matrix expected = Matrix.of(elementsExpected);
        assertTrue(expected.equals(identityMatrix));
    }


    @Test
    public void testGetEigenvalues()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-2), ANumber.of(-3)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        Vector result = matrix1.getRealEigenvalues();
        Vector expected = Vector.of(ANumber.of("-0.9999999999999998"), ANumber.of("-1.9999999999999996"));
        assertTrue(expected.equals(result));
    }


    @Test
    public void testGetEigenvalues2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(-9), ANumber.of(-2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-2), ANumber.of(-2)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        Vector result = matrix1.getRealEigenvalues();
        Vector expected = Vector.of(ANumber.of("-1.468871125850725"), ANumber.of("-9.531128874149275"));
        assertTrue(expected.equals(result));
        OrionList<Vector> elementsExpected = OrionArrayList.of();
        Vector vector1Expected = Vector.of(new ANumber[]
        {ANumber.of("-9.00000000000000120510770703971860890321800958925"), ANumber.of("-2.000000000000000615171992633093738546221250644")});
        Vector vector2Expected = Vector.of(new ANumber[]
        {ANumber.of("-2.000000000000000615171992633093738546221250644"), ANumber.of("-2.00000000000000026596210006778254109678199041075")});
        elementsExpected.append(vector1Expected);
        elementsExpected.append(vector2Expected);
        Matrix matrix1Expected = Matrix.of(elementsExpected);
        assertTrue(matrix1Expected.equals(matrix1.getEigenDecomposition().getOriginalMatrix()));
    }


    @Test
    public void testGetEigenvalues3()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(-3)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        Vector result = matrix1.getRealEigenvalues();
        Vector expected = Vector.of(ANumber.of(-1), ANumber.of(-1));
        assertTrue(expected.equals(result));
    }


    @Test
    public void testGetEigenvalues4()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(-3)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        Vector result = matrix1.getImaginaryEigenvalues();
        Vector expected = Vector.of(ANumber.of(1), ANumber.of(-1));
        assertTrue(expected.equals(result));
    }


    @Test
    public void testGetRank()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(7), ANumber.of(8)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(2).equals(matrix1.getRank()));
    }


    @Test
    public void testGetRank2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(4), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(2), ANumber.of(-1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(8), ANumber.of(-2), ANumber.of(-7)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(2).equals(matrix1.getRank()));
    }


    @Test
    public void testGetRank3()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(0), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-1), ANumber.of(-1), ANumber.of(0), ANumber.of(-2)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(1).equals(matrix1.getRank()));
    }


    @Test
    public void testGetRank4()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(1)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-2), ANumber.of(-3), ANumber.of(1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(5), ANumber.of(0)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(2).equals(matrix1.getRank()));
    }


    @Test
    public void testGetRank5()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(6), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(1).equals(matrix1.getRank()));
    }


    @Test
    public void testGetRank6()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1), ANumber.of(0)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(1)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        assertTrue(ANumber.of(3).equals(matrix1.getRank()));
    }


    @Test
    public void testGetTranspose1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(4), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(6), ANumber.of(2), ANumber.of(-1)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(8), ANumber.of(-2), ANumber.of(-7)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elements2 = OrionArrayList.of();
        Vector vector1a = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(6), ANumber.of(8)});
        Vector vector2a = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(2), ANumber.of(-2)});
        Vector vector3a = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(-1), ANumber.of(-7)});
        elements2.append(vector1a);
        elements2.append(vector2a);
        elements2.append(vector3a);
        Matrix matrix2 = Matrix.of(elements2);
        assertTrue(matrix2.equals(matrix1.transpose()));
    }


    @Test
    public void testGetTranspose2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(0), ANumber.of(2)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(-1), ANumber.of(-1), ANumber.of(0), ANumber.of(-2)});
        elements.append(vector1);
        elements.append(vector2);
        Matrix matrix1 = Matrix.of(elements);
        OrionList<Vector> elements2 = OrionArrayList.of();
        Vector vector1a = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1)});
        Vector vector2a = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1)});
        Vector vector3a = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0)});
        Vector vector4a = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(-2)});
        elements2.append(vector1a);
        elements2.append(vector2a);
        elements2.append(vector3a);
        elements2.append(vector4a);
        Matrix matrix2 = Matrix.of(elements2);
        assertTrue(matrix2.equals(matrix1.transpose()));
    }
}