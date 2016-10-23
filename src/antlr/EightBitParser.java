// Generated from grammar/EightBit.g4 by ANTLR 4.5.3
package eightBit.compile;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EightBitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, NUMBER=19, STRING=20, NOT=21, EQ=22, NEQ=23, LEQ=24, OR=25, 
		TRUE=26, FALSE=27, MUL=28, DIV=29, ADD=30, SUB=31, ID=32, SLC=33, MLC=34, 
		WS=35;
	public static final int
		RULE_eightProgram = 0, RULE_eightFunction = 1, RULE_formals = 2, RULE_idList = 3, 
		RULE_id = 4, RULE_funBody = 5, RULE_emptyStatement = 6, RULE_letStatement = 7, 
		RULE_assignStmtList = 8, RULE_closedStatement = 9, RULE_assignStatement = 10, 
		RULE_whileStatement = 11, RULE_ifStatement = 12, RULE_callStatement = 13, 
		RULE_returnStatement = 14, RULE_blockStatement = 15, RULE_closedList = 16, 
		RULE_expr = 17, RULE_relMonom = 18, RULE_relOperation = 19, RULE_arithOperation = 20, 
		RULE_arithMonom = 21, RULE_arithSingle = 22, RULE_operTDArithSingle = 23, 
		RULE_constant = 24, RULE_arguments = 25, RULE_args = 26;
	public static final String[] ruleNames = {
		"eightProgram", "eightFunction", "formals", "idList", "id", "funBody", 
		"emptyStatement", "letStatement", "assignStmtList", "closedStatement", 
		"assignStatement", "whileStatement", "ifStatement", "callStatement", "returnStatement", 
		"blockStatement", "closedList", "expr", "relMonom", "relOperation", "arithOperation", 
		"arithMonom", "arithSingle", "operTDArithSingle", "constant", "arguments", 
		"args"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fun'", "'('", "')'", "','", "';'", "'let'", "'{'", "'}'", "'='", 
		"'while'", "'if'", "'else'", "'return'", "'&&'", "'>'", "'<'", "'>='", 
		"'null'", null, null, "'!'", "'=='", "'!='", "'<='", "'||'", "'true'", 
		"'false'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "NUMBER", "STRING", "NOT", "EQ", 
		"NEQ", "LEQ", "OR", "TRUE", "FALSE", "MUL", "DIV", "ADD", "SUB", "ID", 
		"SLC", "MLC", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EightBit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EightBitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EightProgramContext extends ParserRuleContext {
		public List<EightFunctionContext> eightFunction() {
			return getRuleContexts(EightFunctionContext.class);
		}
		public EightFunctionContext eightFunction(int i) {
			return getRuleContext(EightFunctionContext.class,i);
		}
		public EightProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eightProgram; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEightProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EightProgramContext eightProgram() throws RecognitionException {
		EightProgramContext _localctx = new EightProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eightProgram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				eightFunction();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EightFunctionContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FormalsContext formals() {
			return getRuleContext(FormalsContext.class,0);
		}
		public FunBodyContext funBody() {
			return getRuleContext(FunBodyContext.class,0);
		}
		public EightFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eightFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEightFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EightFunctionContext eightFunction() throws RecognitionException {
		EightFunctionContext _localctx = new EightFunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eightFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(60);
			id();
			setState(61);
			formals();
			setState(62);
			funBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalsContext extends ParserRuleContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FormalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitFormals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalsContext formals() throws RecognitionException {
		FormalsContext _localctx = new FormalsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__1);
			setState(66);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(65);
				idList();
				}
			}

			setState(68);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			id();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(71);
				match(T__3);
				setState(72);
				id();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EightBitParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunBodyContext extends ParserRuleContext {
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public FunBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitFunBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunBodyContext funBody() throws RecognitionException {
		FunBodyContext _localctx = new FunBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funBody);
		try {
			setState(83);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				letStatement();
				}
				break;
			case T__6:
			case T__9:
			case T__10:
			case T__12:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				closedStatement();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetStatementContext extends ParserRuleContext {
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public AssignStmtListContext assignStmtList() {
			return getRuleContext(AssignStmtListContext.class,0);
		}
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			match(T__6);
			setState(90);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(89);
				assignStmtList();
				}
			}

			setState(92);
			match(T__7);
			setState(93);
			closedStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtListContext extends ParserRuleContext {
		public List<AssignStatementContext> assignStatement() {
			return getRuleContexts(AssignStatementContext.class);
		}
		public AssignStatementContext assignStatement(int i) {
			return getRuleContext(AssignStatementContext.class,i);
		}
		public AssignStmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmtList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitAssignStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtListContext assignStmtList() throws RecognitionException {
		AssignStmtListContext _localctx = new AssignStmtListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignStmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			assignStatement();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(96);
				match(T__4);
				setState(97);
				assignStatement();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosedStatementContext extends ParserRuleContext {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CallStatementContext callStatement() {
			return getRuleContext(CallStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ClosedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitClosedStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosedStatementContext closedStatement() throws RecognitionException {
		ClosedStatementContext _localctx = new ClosedStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_closedStatement);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				assignStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				callStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				returnStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				blockStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStatementContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			id();
			setState(112);
			match(T__8);
			setState(113);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__9);
			setState(116);
			match(T__1);
			setState(117);
			expr();
			setState(118);
			match(T__2);
			setState(119);
			closedStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ClosedStatementContext> closedStatement() {
			return getRuleContexts(ClosedStatementContext.class);
		}
		public ClosedStatementContext closedStatement(int i) {
			return getRuleContext(ClosedStatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__10);
			setState(122);
			match(T__1);
			setState(123);
			expr();
			setState(124);
			match(T__2);
			setState(125);
			closedStatement();
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(126);
				match(T__11);
				setState(127);
				closedStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EightBitParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallStatementContext callStatement() throws RecognitionException {
		CallStatementContext _localctx = new CallStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(ID);
			setState(131);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__12);
			setState(134);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public ClosedListContext closedList() {
			return getRuleContext(ClosedListContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__6);
			setState(138);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << ID))) != 0)) {
				{
				setState(137);
				closedList();
				}
			}

			setState(140);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosedListContext extends ParserRuleContext {
		public List<ClosedStatementContext> closedStatement() {
			return getRuleContexts(ClosedStatementContext.class);
		}
		public ClosedStatementContext closedStatement(int i) {
			return getRuleContext(ClosedStatementContext.class,i);
		}
		public ClosedListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitClosedList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosedListContext closedList() throws RecognitionException {
		ClosedListContext _localctx = new ClosedListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_closedList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			closedStatement();
			setState(144);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(143);
				match(T__4);
				}
			}

			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << ID))) != 0)) {
				{
				{
				setState(146);
				closedStatement();
				setState(148);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(147);
					match(T__4);
					}
				}

				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<RelMonomContext> relMonom() {
			return getRuleContexts(RelMonomContext.class);
		}
		public RelMonomContext relMonom(int i) {
			return getRuleContext(RelMonomContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			relMonom();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(156);
				match(OR);
				setState(157);
				relMonom();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelMonomContext extends ParserRuleContext {
		public List<RelOperationContext> relOperation() {
			return getRuleContexts(RelOperationContext.class);
		}
		public RelOperationContext relOperation(int i) {
			return getRuleContext(RelOperationContext.class,i);
		}
		public RelMonomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relMonom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitRelMonom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelMonomContext relMonom() throws RecognitionException {
		RelMonomContext _localctx = new RelMonomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_relMonom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			relOperation();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(164);
				match(T__13);
				setState(165);
				relOperation();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOperationContext extends ParserRuleContext {
		public Token relOperator;
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
		}
		public RelOperationContext relOperation() {
			return getRuleContext(RelOperationContext.class,0);
		}
		public RelOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitRelOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOperationContext relOperation() throws RecognitionException {
		RelOperationContext _localctx = new RelOperationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relOperation);
		int _la;
		try {
			setState(181);
			switch (_input.LA(1)) {
			case T__1:
			case T__17:
			case NUMBER:
			case STRING:
			case TRUE:
			case FALSE:
			case SUB:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				arithOperation();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << EQ) | (1L << NEQ) | (1L << LEQ))) != 0)) {
					{
					{
					{
					setState(172);
					((RelOperationContext)_localctx).relOperator = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << EQ) | (1L << NEQ) | (1L << LEQ))) != 0)) ) {
						((RelOperationContext)_localctx).relOperator = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					setState(173);
					arithOperation();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(NOT);
				setState(180);
				relOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithOperationContext extends ParserRuleContext {
		public Token oper;
		public ArithMonomContext arithMonom() {
			return getRuleContext(ArithMonomContext.class,0);
		}
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
		}
		public ArithOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationContext arithOperation() throws RecognitionException {
		ArithOperationContext _localctx = new ArithOperationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arithOperation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			arithMonom();
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					{
					setState(184);
					((ArithOperationContext)_localctx).oper = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
						((ArithOperationContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					setState(185);
					arithOperation();
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithMonomContext extends ParserRuleContext {
		public ArithSingleContext arithSingle() {
			return getRuleContext(ArithSingleContext.class,0);
		}
		public List<OperTDArithSingleContext> operTDArithSingle() {
			return getRuleContexts(OperTDArithSingleContext.class);
		}
		public OperTDArithSingleContext operTDArithSingle(int i) {
			return getRuleContext(OperTDArithSingleContext.class,i);
		}
		public ArithMonomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithMonom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithMonom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithMonomContext arithMonom() throws RecognitionException {
		ArithMonomContext _localctx = new ArithMonomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arithMonom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			arithSingle();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					operTDArithSingle();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithSingleContext extends ParserRuleContext {
		public ArithSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithSingle; }
	 
		public ArithSingleContext() { }
		public void copyFrom(ArithSingleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithParsSingleContext extends ArithSingleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArithParsSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithParsSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithMinusSingleContext extends ArithSingleContext {
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ArithMinusSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithMinusSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithIdSingleContext extends ArithSingleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArithIdSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithIdSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithConstantSingleContext extends ArithSingleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ArithConstantSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithConstantSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithSingleContext arithSingle() throws RecognitionException {
		ArithSingleContext _localctx = new ArithSingleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arithSingle);
		int _la;
		try {
			setState(209);
			switch (_input.LA(1)) {
			case SUB:
				_localctx = new ArithMinusSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(SUB);
				setState(199);
				arithOperation();
				}
				break;
			case T__1:
				_localctx = new ArithParsSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__1);
				setState(201);
				expr();
				setState(202);
				match(T__2);
				}
				break;
			case ID:
				_localctx = new ArithIdSingleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				id();
				setState(206);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(205);
					arguments();
					}
				}

				}
				break;
			case T__17:
			case NUMBER:
			case STRING:
			case TRUE:
			case FALSE:
				_localctx = new ArithConstantSingleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperTDArithSingleContext extends ParserRuleContext {
		public Token oper;
		public ArithSingleContext arithSingle() {
			return getRuleContext(ArithSingleContext.class,0);
		}
		public OperTDArithSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operTDArithSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitOperTDArithSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperTDArithSingleContext operTDArithSingle() throws RecognitionException {
		OperTDArithSingleContext _localctx = new OperTDArithSingleContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_operTDArithSingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(211);
			((OperTDArithSingleContext)_localctx).oper = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
				((OperTDArithSingleContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(212);
			arithSingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprNumContext extends ConstantContext {
		public TerminalNode NUMBER() { return getToken(EightBitParser.NUMBER, 0); }
		public ExprNumContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStringContext extends ConstantContext {
		public TerminalNode STRING() { return getToken(EightBitParser.STRING, 0); }
		public ExprStringContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFalseContext extends ConstantContext {
		public ExprFalseContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTrueContext extends ConstantContext {
		public ExprTrueContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNullContext extends ConstantContext {
		public ExprNullContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constant);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new ExprNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new ExprTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new ExprFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				match(FALSE);
				}
				break;
			case T__17:
				_localctx = new ExprNullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__1);
			setState(223);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << NUMBER) | (1L << STRING) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(222);
				args();
				}
			}

			setState(225);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			expr();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(228);
				match(T__3);
				setState(229);
				expr();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\6\2:\n\2\r\2\16\2;\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\5\4E\n\4\3\4\3\4\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\6"+
		"\3\6\3\7\3\7\3\7\5\7V\n\7\3\b\3\b\3\t\3\t\3\t\5\t]\n\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\7\ne\n\n\f\n\16\nh\13\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13p\n"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u0083\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\5\21"+
		"\u008d\n\21\3\21\3\21\3\22\3\22\5\22\u0093\n\22\3\22\3\22\5\22\u0097\n"+
		"\22\7\22\u0099\n\22\f\22\16\22\u009c\13\22\3\23\3\23\3\23\7\23\u00a1\n"+
		"\23\f\23\16\23\u00a4\13\23\3\24\3\24\3\24\7\24\u00a9\n\24\f\24\16\24\u00ac"+
		"\13\24\3\25\3\25\3\25\7\25\u00b1\n\25\f\25\16\25\u00b4\13\25\3\25\3\25"+
		"\5\25\u00b8\n\25\3\26\3\26\3\26\7\26\u00bd\n\26\f\26\16\26\u00c0\13\26"+
		"\3\27\3\27\7\27\u00c4\n\27\f\27\16\27\u00c7\13\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u00d1\n\30\3\30\5\30\u00d4\n\30\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\5\32\u00de\n\32\3\33\3\33\5\33\u00e2\n\33"+
		"\3\33\3\33\3\34\3\34\3\34\7\34\u00e9\n\34\f\34\16\34\u00ec\13\34\3\34"+
		"\2\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2"+
		"\5\4\2\21\23\30\32\3\2 !\3\2\36\37\u00f3\29\3\2\2\2\4=\3\2\2\2\6B\3\2"+
		"\2\2\bH\3\2\2\2\nP\3\2\2\2\fU\3\2\2\2\16W\3\2\2\2\20Y\3\2\2\2\22a\3\2"+
		"\2\2\24o\3\2\2\2\26q\3\2\2\2\30u\3\2\2\2\32{\3\2\2\2\34\u0084\3\2\2\2"+
		"\36\u0087\3\2\2\2 \u008a\3\2\2\2\"\u0090\3\2\2\2$\u009d\3\2\2\2&\u00a5"+
		"\3\2\2\2(\u00b7\3\2\2\2*\u00b9\3\2\2\2,\u00c1\3\2\2\2.\u00d3\3\2\2\2\60"+
		"\u00d5\3\2\2\2\62\u00dd\3\2\2\2\64\u00df\3\2\2\2\66\u00e5\3\2\2\28:\5"+
		"\4\3\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\3\3\2\2\2=>\7\3\2\2>?"+
		"\5\n\6\2?@\5\6\4\2@A\5\f\7\2A\5\3\2\2\2BD\7\4\2\2CE\5\b\5\2DC\3\2\2\2"+
		"DE\3\2\2\2EF\3\2\2\2FG\7\5\2\2G\7\3\2\2\2HM\5\n\6\2IJ\7\6\2\2JL\5\n\6"+
		"\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\t\3\2\2\2OM\3\2\2\2PQ\7\""+
		"\2\2Q\13\3\2\2\2RV\5\20\t\2SV\5\24\13\2TV\5\16\b\2UR\3\2\2\2US\3\2\2\2"+
		"UT\3\2\2\2V\r\3\2\2\2WX\7\7\2\2X\17\3\2\2\2YZ\7\b\2\2Z\\\7\t\2\2[]\5\22"+
		"\n\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\n\2\2_`\5\24\13\2`\21\3\2\2\2"+
		"af\5\26\f\2bc\7\7\2\2ce\5\26\f\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2"+
		"\2g\23\3\2\2\2hf\3\2\2\2ip\5\26\f\2jp\5\30\r\2kp\5\32\16\2lp\5\34\17\2"+
		"mp\5\36\20\2np\5 \21\2oi\3\2\2\2oj\3\2\2\2ok\3\2\2\2ol\3\2\2\2om\3\2\2"+
		"\2on\3\2\2\2p\25\3\2\2\2qr\5\n\6\2rs\7\13\2\2st\5$\23\2t\27\3\2\2\2uv"+
		"\7\f\2\2vw\7\4\2\2wx\5$\23\2xy\7\5\2\2yz\5\24\13\2z\31\3\2\2\2{|\7\r\2"+
		"\2|}\7\4\2\2}~\5$\23\2~\177\7\5\2\2\177\u0082\5\24\13\2\u0080\u0081\7"+
		"\16\2\2\u0081\u0083\5\24\13\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\33\3\2\2\2\u0084\u0085\7\"\2\2\u0085\u0086\5\64\33\2\u0086\35\3"+
		"\2\2\2\u0087\u0088\7\17\2\2\u0088\u0089\5$\23\2\u0089\37\3\2\2\2\u008a"+
		"\u008c\7\t\2\2\u008b\u008d\5\"\22\2\u008c\u008b\3\2\2\2\u008c\u008d\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\n\2\2\u008f!\3\2\2\2\u0090\u0092"+
		"\5\24\13\2\u0091\u0093\7\7\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2"+
		"\u0093\u009a\3\2\2\2\u0094\u0096\5\24\13\2\u0095\u0097\7\7\2\2\u0096\u0095"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b#\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009d\u00a2\5&\24\2\u009e\u009f\7\33\2\2\u009f\u00a1"+
		"\5&\24\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3%\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00aa\5(\25\2"+
		"\u00a6\u00a7\7\20\2\2\u00a7\u00a9\5(\25\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\'\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00b2\5*\26\2\u00ae\u00af\t\2\2\2\u00af\u00b1\5*"+
		"\26\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b8\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\27"+
		"\2\2\u00b6\u00b8\5(\25\2\u00b7\u00ad\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		")\3\2\2\2\u00b9\u00be\5,\27\2\u00ba\u00bb\t\3\2\2\u00bb\u00bd\5*\26\2"+
		"\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf+\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c5\5.\30\2\u00c2"+
		"\u00c4\5\60\31\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6-\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9"+
		"\7!\2\2\u00c9\u00d4\5*\26\2\u00ca\u00cb\7\4\2\2\u00cb\u00cc\5$\23\2\u00cc"+
		"\u00cd\7\5\2\2\u00cd\u00d4\3\2\2\2\u00ce\u00d0\5\n\6\2\u00cf\u00d1\5\64"+
		"\33\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d4\5\62\32\2\u00d3\u00c8\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00ce\3"+
		"\2\2\2\u00d3\u00d2\3\2\2\2\u00d4/\3\2\2\2\u00d5\u00d6\t\4\2\2\u00d6\u00d7"+
		"\5.\30\2\u00d7\61\3\2\2\2\u00d8\u00de\7\25\2\2\u00d9\u00de\7\26\2\2\u00da"+
		"\u00de\7\34\2\2\u00db\u00de\7\35\2\2\u00dc\u00de\7\24\2\2\u00dd\u00d8"+
		"\3\2\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00de\63\3\2\2\2\u00df\u00e1\7\4\2\2\u00e0\u00e2\5\66\34"+
		"\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4"+
		"\7\5\2\2\u00e4\65\3\2\2\2\u00e5\u00ea\5$\23\2\u00e6\u00e7\7\6\2\2\u00e7"+
		"\u00e9\5$\23\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\67\3\2\2\2\u00ec\u00ea\3\2\2\2\31;DMU\\"+
		"fo\u0082\u008c\u0092\u0096\u009a\u00a2\u00aa\u00b2\u00b7\u00be\u00c5\u00d0"+
		"\u00d3\u00dd\u00e1\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}